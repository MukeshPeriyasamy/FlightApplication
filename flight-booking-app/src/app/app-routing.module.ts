import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SearchTicketComponent } from './modules/user/components/search-ticket/search-ticket.component';

const routes: Routes = [
  {path:"home",component:HomePageComponent},
  {path:"home/searchticket",component:SearchTicketComponent},

  {path: "user", loadChildren: ()=>import("./modules/user/user.module").then(M=>M.UserModule)},
  {path: "admin", loadChildren: ()=>import("./modules/admin/admin.module").then(M=>M.AdminModule)},
  {path:"**",redirectTo:"home"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
