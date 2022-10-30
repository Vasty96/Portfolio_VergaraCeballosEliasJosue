import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageproyectoService } from 'src/app/service/imageproyecto.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {

  proyecto: Proyecto = null;

  constructor(private sProyecto: ProyectoService, private activatedRouter: ActivatedRoute, private router: Router, protected imageProyectoService: ImageproyectoService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyecto.detail(id).subscribe(data => {
      this.proyecto = data;
    }, err => {
      alert("Error al actualizar proyecto");
      this.router.navigate(['']);
    }
    )
  }

  onUpdate(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.proyecto.imagenPro = this.imageProyectoService.url;    
    this.sProyecto.update(id, this.proyecto).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert("Error al actualizar el proyecto.");      
      this.router.navigate(['']);
    }
    )
  }

  public uploadImage($event: any){
    const id = this.activatedRouter.snapshot.params['id'];
    const name = `proyecto_${id}`;
    this.imageProyectoService.uploadImage($event, name);
  }
}
