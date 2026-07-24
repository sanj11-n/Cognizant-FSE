import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private employees = [
    { id: 101, name: 'Alex Smith', department: 'Full Stack' },
    { id: 102, name: 'Maria Garcia', department: 'Backend Java' },
    { id: 103, name: 'John Doe', department: 'Angular Frontend' }
  ];

  getEmployees() {
    return this.employees;
  }
}