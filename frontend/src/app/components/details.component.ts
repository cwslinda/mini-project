import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Book } from '../models';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {


  book!: Book
  param$!: Subscription
  bookId!: string
  comments!: string[]
  userId!: string 

  id = localStorage.getItem("userId")!

  constructor(private ar: ActivatedRoute, private router: Router, private bookSvc: BookService) {}
  
  ngOnInit(): void {
    const userId = localStorage.getItem("userId");
    this.param$ = this.ar.params.subscribe(
      (params) => {
        this.bookId = params['bookId']

        this.bookSvc.getSingleBookById(this.bookId)
          .then(result => {
            this.book = result
          }).catch(error => {
            console.log(error)
          })
      }
    )
  }

  
  processForm(){
    const book = this.book
    this.bookSvc.saveBook(book, this.id)
      .then(result =>{
        console.log(book)
      }).catch(error => {
        console.error(error)
      })
   
  }
}
