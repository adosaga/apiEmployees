package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class EmployeeTotal {
	private Employee[] results;

	public Employee[] getResults() {
		return results;
	}

	public void setResults(Employee[] results) {
		this.results = results;
	}
	
	public Employee[] getEmployees() {
			RestTemplate restTemplate = new RestTemplate();
			Employee[] es = restTemplate.getForObject(	"http://masglobaltestapi.azurewebsites.net/api/employees", 
														Employee[].class);
			return es;	
	}
	public Employee[] getEmployeesById(String searchId) {
		RestTemplate restTemplate = new RestTemplate();
		Employee[] es = restTemplate.getForObject(	"http://masglobaltestapi.azurewebsites.net/api/employees", 	
													Employee[].class);
		for(int i=0;i<es.length;i++)
			es[i].setAnnualSalary();
		if(searchId.matches("all")) return es;		
		List<Employee> nuevo = new ArrayList<Employee>();
		String cad[] = searchId.split(",");
		for(int i=0;i<es.length;i++) 
			for(int j=0;j<cad.length;j++)
				if(es[i].getId()==Integer.parseInt(cad[j]))
					nuevo.add(es[i]);
	    Employee[] arr = new Employee[nuevo.size()]; 
	    arr = nuevo.toArray(arr);			
	    return arr;
	}
}
