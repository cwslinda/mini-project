import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, last, lastValueFrom } from "rxjs";
import { Book } from "../models";

@Injectable({
    providedIn: 'root'
})
export class BookService{
    
    constructor(private http: HttpClient){}


    public getBooks(keyword: string): Promise<Book[]>{

        const params = new HttpParams().set("keyword", keyword)

        const headers = new HttpHeaders()
                        .set('content-type', 'application/json')
                        .set('Access-Control-Allow-Origin', '*')

        //return lastValueFrom(this.http.get<Book[]>(`api/search`, {headers, params}))
        return lastValueFrom(this.http.get<Book[]>(`https://skillful-pets-production.up.railway.app/api/search`, {headers, params}))
    }


   public getSingleBookById(bookId: string): Promise<Book>{
    // const params = new HttpParams().set("id", bookId)

    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*')

    return lastValueFrom(this.http.get<Book>(`https://skillful-pets-production.up.railway.app/api/book/${bookId}`, {headers})
    )
   }

   public getBooksFromUser(userId: string): Promise<any>{

            const headers = new HttpHeaders()
            .set('content-type', 'application/json')
            .set('Access-Control-Allow-Origin', '*')

      return lastValueFrom(this.http.get<any>(`https://skillful-pets-production.up.railway.app/api/user/${userId}`, {headers})
      
    )
   }

   public saveBook(book: Book, userId: string): Promise<any>{
    
    

                const form = new FormData()
                form.set("bookId", book.id)
                form.set("title", book.title)
                form.set("text", book.description)
                form.set("authors", book.authors.toString())
                form.set("publishedDate", book.publishedDate)
                form.set("urlLink", book.urlLink)
                form.set("imageUrl", book.imageUrl)
                form.set("previewLink", book.previewLink)
               

              
          
        return lastValueFrom(
                    this.http.post<any>(`https://skillful-pets-production.up.railway.app/api/save/${userId}`, form)
                )
   }

 

}

