import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import path from 'path';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
    {path:'login',component:LoginComponent}
];
