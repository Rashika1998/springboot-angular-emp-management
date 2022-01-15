import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8110/emp/all";
  private createEmpUrl = "http://localhost:8110/emp/save";
  private findByIdEmpUrl = "http://localhost:8110/emp/find";
  private updateEmpUrl = "http://localhost:8110/emp/edit";
  private deleteEmpUrl = "http://localhost:8110/emp/delete";

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseUrl}`);
  }

  createEmployee(employee: Employee):Observable<Object>{
    return this.httpClient.post(`${this.createEmpUrl}`, employee);
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.findByIdEmpUrl}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.updateEmpUrl}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteEmpUrl}/${id}`);
  }


}
