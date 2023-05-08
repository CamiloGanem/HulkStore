import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthService} from "../auth/auth.service";

@Injectable({
  providedIn: 'root'
})
export class ProductoService {


  private URL: String = "http://localhost:1020/api/v1/producto"

  constructor(private http: HttpClient, private auth: AuthService) {
  }

  obtenerProductos(token:String): Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`${this.URL}/consultarTodos`, {headers})
  }

  registrarProducto(producto: any, token: String): Observable<any>{
    console.log(producto)
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post(`${this.URL}/registrar`, producto, {headers});
  }
}
