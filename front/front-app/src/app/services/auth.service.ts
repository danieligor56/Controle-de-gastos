import { Injectable } from '@angular/core';
import { Credenciais } from '../models/credenciais';
import { HttpClient } from '@angular/common/http';
import { API_CONFIG } from '../config/api.confing';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient ) { }

authenticate(creds:Credenciais):Observable<Credenciais>{
   return this.http.post<Credenciais>(`${API_CONFIG.baseUrl}login`,creds)
}




}
