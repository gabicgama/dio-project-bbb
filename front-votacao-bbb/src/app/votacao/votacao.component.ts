import { Component, OnInit } from '@angular/core';
import { Cast } from '../model/cast';

@Component({
  selector: 'app-votacao',
  templateUrl: './votacao.component.html',
  styleUrls: ['./votacao.component.css'],
})
export class VotacaoComponent implements OnInit {
  cast: Cast[] | undefined;

  constructor() {}

  ngOnInit(): void {
    this.getCast();
  }

  getCast() {
    this.cast = [
      { id: '5', name: 'João' },
      { id: '6', name: 'Maria' },
    ];
  }
}
