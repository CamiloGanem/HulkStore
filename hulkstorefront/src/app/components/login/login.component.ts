import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from "../../service/auth/auth.service";



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

  constructor(private auth: AuthService, private router: Router) {
  }

  ngOnInit(): void {}


  onSubmit(): void {
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;
    const usuario: any = {email: email ? email : '',  password: password ? password : ''};

    this.auth.autenticar(usuario).subscribe(res =>{
      this.router.navigate(['/inicio']);
    }, error => {
      console.log(error)})
  }

}
