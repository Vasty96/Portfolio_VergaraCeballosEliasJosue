import { Injectable, OnDestroy } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImageService{
  url: string = "";

  imgName: String = '';

  constructor(private storage: Storage) { }

  public uploadImage($event: any, name: string){
    const file = $event.target.files[0];
    this.imgName = name;
    const imageRef = ref(this.storage, `imagen/` + name);
    uploadBytes(imageRef, file)
    .then(response => {this.getImage()})
    .catch(error => console.log(error))
  }

  getImage(){
    const imagesRef = ref(this.storage, 'imagen')
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