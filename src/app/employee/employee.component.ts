import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.css']
})
export class EmployeeComponent implements OnInit {
  employeesList: any[] = [];

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.employeesList = this.employeeService.getEmployees();
  }
}