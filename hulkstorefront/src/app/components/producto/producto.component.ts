import {Component, Inject} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {AuthService} from "../../service/auth/auth.service";
import {ModalProductoComponent} from "./modal-producto/modal-producto.component";

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent {
  displayedColumns = ['codigo', 'nombre', 'precio', 'stock', 'opciones'];
  dataSource: MatTableDataSource<any>

  productos = [
    {
     codigo:'1',
     nombre:'Camiseta de Hulk',
     precio: '35000.00',
     cantidad: '20'
    },
    {
      codigo:'2',
      nombre:'Camiseta de Spider Man',
      precio: '35000.00',
      cantidad: '20'
    }
    ]

  constructor(public dialog: MatDialog) {
    this.dataSource = new MatTableDataSource<any>([]);
  }

  abrirPopup(): void {
    const dialogRef = this.dialog.open(ModalProductoComponent, {
      width: '600px',
      height: '450px',
      data: { title: 'Registrar Producto' }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
    });
  }

  ngOnInit(): void {
    this.dataSource.data = this.productos;
  }
}
