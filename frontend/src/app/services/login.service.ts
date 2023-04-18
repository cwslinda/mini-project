import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { User } from "../models";



@Injectable({
    providedIn: 'root'
  })
export class LoginService {

    constructor(private http: HttpClient) { }

    createUser(formData: FormData): Promise<any>{

    return firstValueFrom(
        this.http.post<any>('/api/register', formData)
        )

    }
}