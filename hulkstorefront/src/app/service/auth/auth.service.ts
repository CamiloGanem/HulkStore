import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL: String = "http://localhost:1020/api/v1/auth"
  private token: String = "";
  constructor(private http:HttpClient) {}

  autenticar(usuario: any): Observable<any> {
     const datos = this.http.post(`${this.URL}/autenticar`, usuario);
     return datos;
  }

  registarUsuario(usuario: any):Observable<any>{
    return this.http.post(`${this.URL}/registrar`, usuario)
  }

  getToken():Observable<any>{
    return this.http.get(`${this.URL}/getTokenUser`);
  }

}
