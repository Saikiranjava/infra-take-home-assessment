import { Component } from '@angular/core';
import { ApiService } from '../app/api.service';
@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    num: string = '';
    size: number = 0;
    title = 'FINRA Take Home Assessment';
    collection: any = [];
    constructor(private apiService: ApiService) {

    }

    search() {
        /*this.apiService.getPhoneNumbers(this.num).subscribe((data)=>{
            console.log(data);
            this.collection = data;
          });*/
        this.collection = [];
        this.apiService
            .getPhoneNumbers<any[]>(this.num)
            .subscribe((data: any[]) => this.collection = data,
                error => () => {

                },
                () => {
                    this.size = this.collection.length;
                });
    }
}