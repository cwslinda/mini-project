import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import { LoginComponent } from './components/login.component';
import { LoginService } from './services/login.service';
import { RouterModule, Routes } from '@angular/router';
import { ResultsComponent } from './components/results.component';

const appRoutes: Routes = [
  {
    path: '', component: HomeComponent,
    //canDeactivate: [ ContactRepository ]
  },
  { path: 'books/:keyword', component: ResultsComponent},
  {
    path: 'login',
    component: LoginComponent,
  },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ResultsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
