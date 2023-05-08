import {Component, OnInit} from '@angular/core';
import {AppComponent} from "../../app.component";
import {ProductoService} from "../../service/producto/producto.service";
import {AuthService} from "../../service/auth/auth.service";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit{

  productos: any;
  constructor(private app:AppComponent, private prodService: ProductoService,
              private auth:AuthService) {
    this.app.isLoggedIn = true;
  }

  ngOnInit() {
    this.obtenerProductos();
  }

  obtenerProductos():void{
    this.auth.getToken().subscribe(res => {
      var token = res.dato
      this.prodService.obtenerProductos(token).subscribe(res => {
        console.log(res);
        this.productos = res.dato;
      })
    });

  }



}
