import { Persona } from './../../domain/persona';
import { Response } from './../../domain/response';
import { ConexionRestService } from './../../services/conexion-rest.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent {

  loading: boolean;
  mostrarFormulario: boolean;
  formulario: FormGroup;

  response = new Response();
  persona = new Persona();


  constructor(private fb: FormBuilder, private conexion: ConexionRestService) {
    this.mostrarFormulario = true;
    this.crearFormulario();
  }


  get nombreNoValido(): boolean {
    return this.formulario.get('nombre').invalid && this.formulario.get('nombre').touched;
  }

  get apellidoNoValido(): boolean {
    return this.formulario.get('apellido').invalid && this.formulario.get('apellido').touched;
  }

  get fechaNacimientoNoValido(): boolean {
    return this.formulario.get('fechaNacimiento').invalid && this.formulario.get('fechaNacimiento').touched;
  }

  get validacionMostrarDias(): boolean {
    return this.response != null &&
      this.response.serviceStatus != null &&
      this.response.serviceStatus.codigo === 0 &&
      this.response.serviceStatus.detalle === 'ok_dias';
  }

  get validacionMostrarPoema(): boolean {
    return this.response != null &&
      this.response.serviceStatus != null &&
      this.response.serviceStatus.codigo === 0 &&
      this.response.serviceStatus.detalle === 'ok_poem';
  }
  
  crearFormulario(): void {
    this.formulario = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(1), Validators.pattern('[a-zA-Z ]*')]],
      apellido: ['', [Validators.required, Validators.minLength(1), Validators.pattern('[a-zA-Z ]*')]],
      fechaNacimiento: ['', Validators.required],
    });
  }

  buscar(): void {

    console.log(this.formulario);

    if (this.formulario.invalid) {
      return Object.values(this.formulario.controls).forEach(control => {
        control.markAsTouched();
      });
    } else {
      this.loading = true;
      console.log(this.formulario);
      this.llamarBackEnd();
    }
  }

  llamarBackEnd() {
    this.conexion.getLogicaPruebaTecnica(this.formulario.value.fechaNacimiento)
      .subscribe((data: Response) => {
        console.log('data ' + JSON.stringify(data));
        this.response = data;
        this.loading = false;
        this.mostrarResultado();
      });
  }

  mostrarResultado(): void {

    this.persona.nombre = this.formulario.value.nombre.split(' ', 1);
    this.persona.apellido = this.formulario.value.apellido.split(' ', 1);

    this.mostrarFormulario = false;
  }

  volver(): void {
    this.mostrarFormulario = true;
    this.response = null;
    this.loading = false;
    this.formulario.reset();
  }

}
