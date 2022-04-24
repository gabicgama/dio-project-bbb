import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { VotingComponent } from './voting/voting.component';
import { AppRoutingModule } from './app-routing.module';
import { RegisterVotingComponent } from './register-voting/register-voting.component';

@NgModule({
  declarations: [AppComponent, VotingComponent, RegisterVotingComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
