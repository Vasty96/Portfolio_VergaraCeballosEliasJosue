import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-about',
  templateUrl: './edit-about.component.html',
  styleUrls: ['./edit-about.component.css']
})
export class EditAboutComponent implements OnInit {

  persona: persona = null;

  constructor(private personaService: PersonaService, private activatedRouter: ActivatedRoute, private router: Router, protected imageService: ImageService) { }

  ngOnInit(): void {    
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.detail(id).subscribe(data => {
      this.persona = data;
    }, err => {
      alert("Error al actualizar persona");
      this.router.navigate(['']);
    }
    )
  }

  onUpdate(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.persona.img = this.imageService.url;
    this.personaService.update(id, this.persona).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert("Error al actualizar la persona.");
      console.log(err);
      
      this.router.navigate(['']);
    }
    )

  }

  public uploadImage($event: any){
    const id = this.activatedRouter.snapshot.params['id'];
    const name = "perfil_" + id;
    this.imageService.uploadImage($event, name);
  }
}
