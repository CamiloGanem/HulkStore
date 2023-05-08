import {Component, OnInit, ViewChild} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from "../../service/auth/auth.service";
import {MatDialog} from "@angular/material/dialog";
import {ModalUsuarioComponent} from "../usuario/modal-usuario/modal-usuario.component";
import {AppComponent} from "../../app.component";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  constructor(private auth: AuthService, private router: Router, public dialog: MatDialog,
              private appComponent: AppComponent) {

    this.appComponent.isLoggedIn = false;

  }

  ngOnInit(): void {
  }


  onSubmit(): void {
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;
    const usuario: any = {email: email ? email : '',  password: password ? password : ''};

    this.auth.autenticar(usuario).subscribe(() =>{
      this.router.navigate(['/inicio']);
    }, error => {
      console.log(error)
      alert("Usuario no valido, por favor intente nuevamente.")
    })
  }

  abrirPopup() {
    const dialogRef = this.dialog.open(ModalUsuarioComponent, {
      width: '600px',
      height: '500px',
      data: { title: 'Registro de usuario', name: '', password: '' }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
    });
  }
}
