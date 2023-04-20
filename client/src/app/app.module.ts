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
import { DetailsComponent } from './components/details.component';
import { BookService } from './services/book.service';

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
  { path: 'home/:id', component: HomeComponent },
  { path: 'book/:bookId', component: DetailsComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' },
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ResultsComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [LoginService, BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
