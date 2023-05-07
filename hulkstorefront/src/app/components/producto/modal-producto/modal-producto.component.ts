import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-modal-producto',
  templateUrl: './modal-producto.component.html',
  styleUrls: ['./modal-producto.component.css']
})
export class ModalProductoComponent {

  form!: FormGroup;

  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<ModalProductoComponent>) {
    this.initFormulario();
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
    console.log(this.form.value);
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }

}
