import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  url: string = "";

  constructor(private storage: Storage) { }

  public uploadImage($event: any, name: string){
    const file = $event.target.files[0];
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
        this.url = await getDownloadURL(item);
        console.log(this.url);
      }
    })
    .catch(error => console.log(error))
  }
}
