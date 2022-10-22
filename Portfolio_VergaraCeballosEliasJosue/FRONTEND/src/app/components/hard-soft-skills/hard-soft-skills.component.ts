import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hard-soft-skills',
  templateUrl: './hard-soft-skills.component.html',
  styleUrls: ['./hard-soft-skills.component.css']
})
export class HardSoftSkillsComponent implements OnInit {
  skill: Skill[] = [];

  constructor(private skills: SkillService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {

    this.cargarExperiencia();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void{
    this.skills.lista().subscribe(data => this.skill = data);
  }

  delete(id?: number){
    if(id != undefined){
      this.skills.delete(id).subscribe(data=>{
        this.cargarExperiencia();
      }, err =>{
        alert("No se pudo borrar la skill");
      })
    }
  }
}
