import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
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

        return lastValueFrom(this.http.get<Book[]>(`api/search`, {headers, params}))
    }
}