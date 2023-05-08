import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AuthService} from "../../../service/auth/auth.service";
import {ProductoService} from "../../../service/producto/producto.service";

@Component({
  selector: 'app-modal-producto',
  templateUrl: './modal-producto.component.html',
  styleUrls: ['./modal-producto.component.css']
})
export class ModalProductoComponent implements OnInit{

  form!: FormGroup;

  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<ModalProductoComponent>,
              private auth:AuthService, private pService: ProductoService,
              @Inject(MAT_DIALOG_DATA) public data: any) {
    this.initFormulario();
    console.log(this.data)
  }

  ngOnInit(): void {
    if(this.data.reg !== undefined){
      this.initFormularioEdit()
    }else {
      this.initFormulario();
    }
  }

  initFormulario(): void {
    this.form = this.fb.group({
      codigo:['', Validators.required],
      nombre:['', Validators.required],
      descripcion:[''],
      precio:[0, Validators.required],
      stock:[0, Validators.required]
    })
  }

  guardar(){
    const producto =
      {
        id_producto: this.data.reg !== undefined ? this.data.reg.id_producto : "",
        codigo_producto: this.form.value.codigo,
        nombre_producto: this.form.value.nombre,
        descripcion_producto: this.form.value.descripcion,
        precio_producto: this.form.value.precio,
        cantidad_producto: this.form.value.stock
      };

    this.auth.getToken().subscribe(res => {
      var token = res.dato;
      this.pService.registrarProducto(producto, token).subscribe(res => {
        alert(res.mensaje);

        this.dialogRef.close()
      }, error => {
        console.log(error)
      })
    }, error => console.log(error))
  }

  initFormularioEdit(){
    this.form = this.fb.group({
      codigo:[this.data.reg.codigo_producto, Validators.required],
      nombre:[this.data.reg.nombre_producto, Validators.required],
      descripcion:[this.data.reg.descripcion_producto],
      precio:[this.data.reg.precio_producto, Validators.required],
      stock:[this.data.reg.cantidad_producto, Validators.required]
    })
  }

  onCancelClick(): void {
    console.log()
    this.dialogRef.close();
  }

}
