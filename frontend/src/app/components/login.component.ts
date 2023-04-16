import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { User } from '../models';
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

  constructor(private fb: FormBuilder, private loginSvc: LoginService) { }
  
  
  
  
  ngOnInit(): void {
    this.initForm();
  }



  processLogin(){
    const user: User = this.loginForm.value as User 
    this.loginSvc.saveuser(user)
      .then(result => {
        console.info(">>> result", result)
        this.initForm()
      })
      .catch(error => {
        console.info('>>>> error: ', error)
      })

  
  }


  private initForm() {
    this.loginForm = this.createForm()
    if (this.values$) {
      this.values$.unsubscribe()
      this.state$.unsubscribe()
    }
    this.values$ = this.loginForm.valueChanges.subscribe(
      (values: any) => {
        console.info('>>> values: ', values)
      }
    )
    this.state$ = this.loginForm.statusChanges.subscribe(
      (state: any) => {
        console.info('>>> state: ', state)
      }
    )
  }

  private createForm(): FormGroup {
    return this.fb.group({
      username: this.fb.control('', [ Validators.required ]),
      password: this.fb.control('', [ Validators.required ]),
    })
  }
  





}
