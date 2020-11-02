import { FormularioComponent } from './pages/formulario/formulario.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'formulario', component: FormularioComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'formulario' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
