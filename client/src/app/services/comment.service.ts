import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, last, lastValueFrom } from "rxjs";
import { Book, CommentResult } from "../models";

@Injectable({
    providedIn: 'root'
})
export class CommentService{

    constructor(private http: HttpClient) { }


postComment(formData: FormData): Promise<any>{
    console.log("in service - postComment")

    console.log(formData)

    return firstValueFrom(
        this.http.post<any>(`api/comment/save`, formData)
    )
}


 getComments(bookId: string): Promise<CommentResult[]>{

    const params = new HttpParams().set("bookId", bookId)

    const headers = new HttpHeaders()
                    .set('content-type', 'application/json')
                    .set('Access-Control-Allow-Origin', '*')

    return lastValueFrom(this.http.get<CommentResult[]>(`api/${bookId}/comments`, {headers, params}))
}
}