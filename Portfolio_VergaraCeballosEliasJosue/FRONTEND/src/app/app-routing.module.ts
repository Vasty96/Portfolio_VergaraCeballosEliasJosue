import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAboutComponent } from './components/about/edit-about.component';
import { EditEducacionComponent } from './components/education/edit-educacion.component';
import { NewEducacionComponent } from './components/education/new-educacion.component';
import { EditExperienciaComponent } from './components/experience/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experience/new-experiencia.component';
import { EditSkillComponent } from './components/hard-soft-skills/edit-skill.component';
import { NewSkillComponent } from './components/hard-soft-skills/new-skill.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path:'editexp/:id', component: EditExperienciaComponent},
  {path: 'nuevaedu', component: NewEducacionComponent},
  {path:'editedu/:id', component: EditEducacionComponent},
  {path: 'newskill', component:NewSkillComponent},
  {path: 'editskill/:id', component:EditSkillComponent},
  {path: 'editabout/:id', component:EditAboutComponent},
  {path: 'nuevopro', component:NewProyectoComponent},
  {path: 'editpro/:id', component:EditProyectoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
