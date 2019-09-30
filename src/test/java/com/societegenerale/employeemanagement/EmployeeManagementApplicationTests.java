package com.societegenerale.employeemanagement;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.societegenerale.employeemanagement.bean.Employee;
import com.societegenerale.employeemanagement.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeManagementApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService empService;
	List<Employee> empList = new ArrayList<>();
	{
		empList.add(new Employee(1, "Test_1", "Employee", "Male", new Date(), "Lead",
				"http://res.publicdomainfiles.com/pdf_view/68/13927384215784.png"));
		empList.add(new Employee(2, "Test_2", "Employee", "Male", new Date(), "Manager",
				"http://res.publicdomainfiles.com/pdf_view/68/13927384215784.png"));
		empList.add(new Employee(3, "Test_3", "Employee", "Female", new Date(), "Engineer",
				"https://publicdomainvectors.org/photos/female-user-icon.png"));
		empList.add(new Employee(4, "Test_4", "Employee", "Male", new Date(), "Engineer",
				"http://res.publicdomainfiles.com/pdf_view/68/13927384215784.png"));
	}

	@Test
	public void listAllEmployees() throws Exception {

		when(empService.getEmployees()).thenReturn(empList);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON))
				.andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = " [{ id :1, firstName : Test_1 , lastName : Employee , gender : Male , dateOfBirth : 2019-09-22 , department : Lead },{ id :2, firstName : Test_2 , lastName : Employee , gender : Male , dateOfBirth : 2019-09-22 , department : Manager },{ id :3, firstName : Test_3 , lastName : Employee , gender : Female , dateOfBirth : 2019-09-22 , department : Engineer },{ id :4, firstName : Test_4 , lastName : Employee , gender : Male , dateOfBirth : 2019-09-22 , department : Engineer }]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void getEmployeesById() throws Exception {
		int id = 2;
		Optional<Employee> findAny = empList.stream().filter(emp -> emp.getId() == id).findAny();
		if (findAny.isPresent()) {

			when(empService.getEmployee(id)).thenReturn(findAny.get());
			MvcResult result = mvc
					.perform(MockMvcRequestBuilders.get("/employees/{id}", 2).accept(MediaType.APPLICATION_JSON))
					.andReturn();

			System.out.println(result.getResponse().getContentAsString());
			String expected = "{ id :2, firstName : Test_2 , lastName : Employee , gender : Male , dateOfBirth : 2019-09-22 , department : Manager }";
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		}

	}

	@Test
	public void addEmployee() throws Exception {
		String input = "{\n" + "    \"id\": 5,\n" + "    \"firstName\": \"New_Test\",\n"
				+ "    \"lastName\": \"Employee\",\n" + "    \"gender\": \"Female\",\n"
				+ "    \"dateOfBirth\": \"1985-04-10\",\n" + "    \"department\": \"Intern\"\n" + "}";
		Employee emp = new Employee(5, "New_Test", "Employee", "Female", new Date(), "Intern",
				"https://publicdomainvectors.org/photos/female-user-icon.png");
		ResultMatcher created = MockMvcResultMatchers.status().isCreated();
		when(empService.saveEmployee(emp)).thenReturn(emp);
		mvc.perform(MockMvcRequestBuilders.post("/employees").contentType(MediaType.APPLICATION_JSON).content(input))
				.andExpect(created);

	}

	@Test
	public void editEmployee() throws Exception {
		String input = "{\n" + "    \"id\": 5,\n" + "    \"firstName\": \"New_Test\",\n"
				+ "    \"lastName\": \"Employee\",\n" + "    \"gender\": \"Male\",\n"
				+ "    \"dateOfBirth\": \"1985-04-10\",\n" + "    \"department\": \"Intern\"\n" + "}";
		Employee emp = new Employee(5, "New_Test", "Employee", "Male", new Date(), "Intern",
				"http://res.publicdomainfiles.com/pdf_view/68/13927384215784.png");
		ResultMatcher created = MockMvcResultMatchers.status().isCreated();
		when(empService.updateeEmployee(emp, 5)).thenReturn(emp);
		mvc.perform(
				MockMvcRequestBuilders.put("/employees/{id}", 5).contentType(MediaType.APPLICATION_JSON).content(input))
				.andExpect(created);

	}

	@Test
	public void removeEmployee() throws Exception {
		String output = "{ id :2, firstName : Test_2 , lastName : Employee , gender : Male , dateOfBirth : 2019-09-22 , department : Manager }";
		Employee emp = new Employee(2, "Test_2", "Employee", "Male", new Date(), "Manager",
				"http://res.publicdomainfiles.com/pdf_view/68/13927384215784.png");
		ResultMatcher moved = MockMvcResultMatchers.status().isMovedPermanently();
		when(empService.removeEmployee(2)).thenReturn(emp);
		mvc.perform(MockMvcRequestBuilders.delete("/employees/{id}", 5).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(moved);

	}

}
