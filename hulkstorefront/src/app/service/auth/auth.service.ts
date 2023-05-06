import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL: String = "http://localhost:1020/api/v1/auth"
  constructor(private http:HttpClient) {}

  autenticar(usuario: any): Observable<any>{
    return this.http.post(`${this.URL}/autenticar`, usuario);
  }

}
