import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageproyectoService } from 'src/app/service/imageproyecto.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {

  nombrePro: string = '';
  descripcionPro: string = '';
  imagePro: string = '';


  constructor(private sProyecto: ProyectoService, private activatedRouter: ActivatedRoute, private router: Router, protected imageProyectoService: ImageproyectoService) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const proy = new Proyecto(this.nombrePro, this.descripcionPro, this.imageProyectoService.url);
    this.sProyecto.save(proy).subscribe(data=>{
      alert("Proyecto añadido");
      this.router.navigate(['']);
    }, err=>{
      alert("Fallo");
      this.router.navigate(['']);
    })
  }

  public uploadImage($event: any){
    const id = this.activatedRouter.snapshot.params['id'];
    const name = "proyecto_" + id;
    this.imageProyectoService.uploadImage($event, name);
  }
}
