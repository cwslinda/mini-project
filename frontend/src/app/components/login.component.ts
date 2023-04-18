import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginForm!: FormGroup
  values$!: Subscription
  state$!: Subscription
  id!: string 

  constructor(private fb: FormBuilder, private router: Router,private loginSvc: LoginService) { }


 
  ngOnInit(): void {
    this.loginForm = this.createForm()  }

  createUser(){

    const formData = new FormData()
    formData.set("username", this.loginForm.value['username'])
    formData.set("password", this.loginForm.value['password'])


    this.loginSvc.createUser(formData).then(result => {
      this.id = result["id"]
    }).catch(error => {
      console.log(error)
    })

    
 
    this.loginForm = this.createForm()
  }

 

  private createForm(): FormGroup {
    return this.fb.group({
      username: this.fb.control('', [ Validators.required ]),
      password: this.fb.control('', [ Validators.required ]),
    })
  }
  





}
