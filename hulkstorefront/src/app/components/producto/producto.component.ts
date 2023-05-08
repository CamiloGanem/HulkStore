import {Component, Inject, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {AuthService} from "../../service/auth/auth.service";
import {ModalProductoComponent} from "./modal-producto/modal-producto.component";
import {ProductoService} from "../../service/producto/producto.service";

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit{
  displayedColumns = ['codigo', 'nombre', 'precio', 'stock', 'opciones'];
  dataSource: MatTableDataSource<any>

  constructor(public dialog: MatDialog, private service: ProductoService, private auth: AuthService) {
    this.dataSource = new MatTableDataSource<any>([]);
  }

  ngOnInit(): void {
    this.obtenerProductos();
  }

  obtenerProductos():void{
    this.auth.getToken().subscribe(res => {
      var token = res.dato
      this.service.obtenerProductos(token).subscribe(res => {
        console.log(res);
        this.dataSource.data = res.dato;
      })
    });

  }

  abrirPopup(): void {
    const dialogRef = this.dialog.open(ModalProductoComponent, {
      width: '600px',
      height: '450px',
      data: { title: 'Registrar Producto' }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.obtenerProductos();
    });
  }

  abirirPapupEditar(producto: any): void {
    const dialogRef = this.dialog.open(ModalProductoComponent, {
      width: '600px',
      height: '450px',
      data: { title: 'Registrar Producto', reg: producto}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.obtenerProductos();
    });
  }
}
