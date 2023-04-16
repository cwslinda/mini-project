import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {



  form!: FormGroup

  constructor(private fb: FormBuilder, private router: Router){}

  ngOnInit(): void {
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
