import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarios: any[] = [
    { id: 1, nombre: 'Usuario 1', email: 'user1@example.com', password: '123', token: '' },
    { id: 2, nombre: 'Usuario 2', email: 'user2@example.com', password: '321', token: ''},
  ];

  private usuarioActual: any | null = null;

  login(usuario: any): any {
    const usuarioAutenticado = this.usuarios.find(u =>
      u.email === usuario.email && u.password === usuario.password);

    if (usuarioAutenticado) {
      usuarioAutenticado.token = 'dummy_token';
      this.usuarioActual = usuarioAutenticado;
      return true;
    }
    return false;
  }

  logout(): void {
    if (this.usuarioActual) {
      delete this.usuarioActual.token;
      this.usuarioActual = null;
    }
  }

  getUsuarioActual(): any | null {
    return this.usuarioActual;
  }

  isAuthenticated(): boolean {
    return !!this.usuarioActual?.token;
  }
}
