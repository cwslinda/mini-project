import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { User } from "../models";



@Injectable()
export class LoginService {

    constructor(private http: HttpClient) { }

    saveuser(user: User): Promise<User>{

        const payload = new HttpParams()
        .set("name", user.username)
        .set("password", user.password)

        const headers = new HttpHeaders()
        .set("Content-Type", "application/x-www-form-urlencoded")
        .set("Accept", "application/json")
       

        return firstValueFrom(
            this.http.post<User>(`api/login`
                , payload.toString(), { headers })
          )

    }
}