import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Book, User } from '../models';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  user!: User
  form!: FormGroup
  param$!: Subscription
  userId!: string
  username!: string
  books!: Book[]



  constructor(private fb: FormBuilder, private router: Router, private ar: ActivatedRoute, private bookSvc: BookService){}

  ngOnInit(): void {
    this.param$ = this.ar.params.subscribe(
      (params) => {
    
        this.userId = params['id']
        
        this.bookSvc.getBooksFromUser(this.userId)
          .then(result => {
            this.books = result['books']
            console.log(this.books)

          }).catch(error => {
            console.log(error)

          })
       
      }
    )
    this.form = this.createForm();
  }


  search(){
    const keyword: string = this.form.value['keyword']
    console.log("search for", keyword)

    this.router.navigate([`/books/${keyword}`])
  }

  createForm(): FormGroup {
    return this.fb.group({
      keyword: this.fb.control<string>("", [Validators.required])
    })

  }

}
