import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestService } from '../service/RestService';
import { Cast } from '../model/cast';

@Component({
  selector: 'app-registrar-votacao',
  templateUrl: './register-voting.component.html',
  styleUrls: ['./register-voting.component.css'],
})
export class RegisterVotingComponent implements OnInit {
  title = 'Voto computado';
  vote = '';

  constructor(
    private route: ActivatedRoute,
    private restService: RestService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.sendVote(params['id']);
    });
  }

  sendVote(id: string) {
    let request = { id: id };
    this.restService.postData('/voting', request).subscribe((response) => {
      console.log(response);
      let vote = response as Cast;
      this.vote = vote.name;
    });
  }
}
