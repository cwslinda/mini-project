import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Book } from '../models';
import { BookService } from '../services/book.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommentService } from '../services/comment.service';

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
  commentForm!: FormGroup
  commentId!: string

  id = localStorage.getItem("userId")!

  constructor(private ar: ActivatedRoute, private router: Router, private bookSvc: BookService, private commentSvc: CommentService, private fb: FormBuilder,) {}
  
  ngOnInit(): void {
    const userId = localStorage.getItem("userId");

    this.commentForm = this.createForm();

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
        this.router.navigate([`/home/${this.id}`])
      }).catch(error => {
        console.error(error)
      })
   
  }

  processCommentForm(){
   const formData = new FormData();
   formData.set("userId", this.id)
   formData.set("bookId", this.bookId)
   formData.set("comment", this.commentForm.value["comment"])
   formData.set("commentTitle", this.commentForm.value["title"])

   this.commentSvc.postComment(formData).then(result => {
    this.commentId = result["commentId"]
   }).catch((error: any) =>{
    console.log(error)
   })

   this.commentForm = this.createForm();
  }


  createForm(): FormGroup {
    return this.fb.group({
      title: this.fb.control<string>(''),
      comment: this.fb.control<string>('')
    })
  }

  back(){
    if(this.id != null){
      this.router.navigate([`/home/${this.id}`])
    } else {
      this.router.navigate([`/home`])

    }

  }
}
