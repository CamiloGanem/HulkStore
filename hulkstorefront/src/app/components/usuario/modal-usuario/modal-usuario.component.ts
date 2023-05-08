import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../service/auth/auth.service";

@Component({
  selector: 'app-modal-usuario',
  templateUrl: './modal-usuario.component.html',
  styleUrls: ['./modal-usuario.component.css']
})
export class ModalUsuarioComponent implements OnInit {

  form!: FormGroup;
  constructor(public dialogRef: MatDialogRef<ModalUsuarioComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, private fm: FormBuilder,
              private auth: AuthService) {

    this.iniciarFormulario();
  }

  ngOnInit(): void {}

  onCancelClick(): void {
    this.dialogRef.close();
  }

  guardar(): void {
    console.log(this.form.value);
    const usuario:any =
      {
        firtName: this.form.value.primer_nombre,
        lastName: this.form.value.primer_apellido,
        email: this.form.value.email,
        password:this.form.value.password,
        empleado:{
          id_empleado:"",
          iden_empleado: this.form.value.iden_empleado,
          primer_nom_empleado: this.form.value.primer_nombre,
          segundo_nom_empleado: this.form.value.segundo_nombre,
          primer_apell_empleado: this.form.value.primer_apellido,
          segundo_apell_empleado: this.form.value.segundo_apellido,
          fecha_nac_empleado: this.form.value.fecha_nac
        }
    }

    this.auth.registarUsuario(usuario).subscribe( res => {
      console.log(res)
      alert(res.mensaje);
    }, error => {
      console.log(error)
      alert(error.error.text)
    });
  }

  iniciarFormulario():void{
    this.form = this.fm.group(
      {
        primer_nombre: ['', Validators.required],
        segundo_nombre: [''],
        primer_apellido:['', Validators.required],
        segundo_apellido:[''],
        iden_empleado:['', Validators.required],
        fecha_nac: ['', Validators.required],
        email: ['', Validators.required],
        password:['', Validators.required]
      }
    )
  }

}
