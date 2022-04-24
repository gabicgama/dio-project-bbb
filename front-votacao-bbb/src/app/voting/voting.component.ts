import { Component, OnInit } from '@angular/core';
import { Cast } from '../model/cast';
import { RestService } from '../service/RestService';

@Component({
  selector: 'app-votacao',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css'],
})
export class VotingComponent implements OnInit {
  title = 'Votação BBB 22';
  cast: Cast[] | undefined;

  constructor(private restService: RestService) {}

  ngOnInit(): void {
    this.getCast();
  }

  getCast() {
    this.restService.getData('/cast/findAll').subscribe((cast) => {
      this.cast = cast;
    });
  }
}
