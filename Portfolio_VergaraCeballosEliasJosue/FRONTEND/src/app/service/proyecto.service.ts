import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {
  URL =  environment.URL + 'proyecto/';

  constructor(private HttpClient: HttpClient) { }

  public lista(): Observable<Proyecto[]>{
    return this.HttpClient.get<Proyecto[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<Proyecto>{
    return this.HttpClient.get<Proyecto>(this.URL + `detail/${id}`);
  }

  public save(proyecto: Proyecto): Observable<any>{
    return this.HttpClient.post<any>(this.URL + 'create', proyecto);
  }

  public update(id: number, proyecto: Proyecto): Observable<any>{
    return this.HttpClient.put<any>(this.URL + `update/${id}`, proyecto);
  }

  public delete(id:number): Observable<any>{
    return this.HttpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
