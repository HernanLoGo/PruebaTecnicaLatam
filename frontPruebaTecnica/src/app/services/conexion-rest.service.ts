import { Response } from './../domain/response';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConexionRestService {

  constructor(private http: HttpClient) { }


  getQuery(query: string) {
    const url = `http://localhost:8081/prueba-tecnica/logica${query}`;

    return this.http.get(url);
  }

  getLogicaPruebaTecnica(fechaCumpleanios: string) {
    return this.getQuery(`?fechacumpleanio=${fechaCumpleanios}`)
      .pipe(map(data => data as Response));
  }
}
