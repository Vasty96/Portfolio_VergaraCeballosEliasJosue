import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImageproyectoService {
  url: string = "";

  imgName: String = '';

  constructor(private storage: Storage) { }

  public uploadImage($event: any, name: string){
    const file = $event.target.files[0];
    var includes: boolean = false;
    
    if(name.includes('undefined')){
      
      includes = true

      const imagesRef = ref(this.storage, 'proyecto');

      let imgCounter : number = 1;     

      list(imagesRef)
      .then(response => {
      for(let item of response.items)
        imgCounter = imgCounter + 1;
      
      name += "TEMPNAME" + imgCounter;
      
      this.cargar(file, name);
      })
      .catch(error => console.log(error))
    }
    
    if(!includes){
      this.cargar(file, name);
    }
  }

  private cargar(file: any, name: string){
      this.imgName = name;    
      const imageRef = ref(this.storage, `proyecto/` + this.imgName);
      uploadBytes(imageRef, file)
      .then(response => {this.getImage()})
      .catch(error => console.log(error))
  }

  getImage(){
    const imagesRef = ref(this.storage, 'proyecto')
    list(imagesRef)
    .then(async response => {
      for(let item of response.items){
        if(item.name == this.imgName){
          this.url = await getDownloadURL(item);
          console.log(this.url);
        }
      }
    })
    .catch(error => console.log(error))
  }
}
