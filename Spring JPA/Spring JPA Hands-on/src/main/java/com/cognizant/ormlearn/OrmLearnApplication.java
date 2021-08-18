package com.cognizant.ormlearn;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
//	@Autowired
//	private static StockRepository stockRepository;
	@Autowired
	private static EmployeeService employeeService;
	@Autowired
	private static DepartmentService departmentService;
	@Autowired
	private static SkillService skillService;
	
	private static void testGetEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");

		}


	private static void testAddEmployee() throws Exception{
		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setName("Sindhu");
		employee.setSalary(new BigDecimal(99999));
		employee.setPermanent(true);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date dob=sdf.parse("02/07/2000");
		employee.setDateOfBirth(dob);
		employee.setDepartment(departmentService.get(1));
		employeeService.save(employee);
		LOGGER.info("End");
		
	}
	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(5);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		employee.setDepartment(departmentService.get(2));
		employeeService.save(employee);
	}
	
	private static void testgetDepartment() {
		LOGGER.info("Start");
		Department department=departmentService.get(3);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employee:{}", department.getEmployeeList());
		LOGGER.info("End");
		
	}

	private static void testgetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(2);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skill:{}", employee.getSkillList());
		employeeService.save(employee);
		
	}
	private static void testAddSkillToEmployee(){
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		employee.getSkillList().add(skill);
		
		employeeService.save(employee);
		
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Application Started...");
	//	stockRepository=context.getBean(StockRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		testAddSkillToEmployee();
	//	testgetEmployee();
	//	testgetDepartment();
	//	departmentService=context.getBean(DepartmentService.class);
	//	testGetEmployee();
	//  testAddEmployee();
	//	testUpdateEmployee();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//1st query
//		List<Stock> stockList=stockRepository.findStockByCodeAndMonthAndYear("FB", 9, 2019);
//		LOGGER.info("stock:{}",stockList);
		
		//2nd query
//		List<Stock> stockList=stockRepository.findStockPriceGT();
//		LOGGER.info("stock:{}",stockList);	
		
		//3rd query
//		List<Stock> stockList=stockRepository.top3Volume();
//		LOGGER.info("stock:{}",stockList);	
		
		//4th query
//		List<Stock> stockList=stockRepository.least3Stocks();
//		LOGGER.info("stock:{}",stockList);		
		
		
		//3rd query alternative way
//		List<Stock> stockList=stockRepository.findByStockCodeAndVolume("FB", Sort.by("volume"));
//		stockList.forEach(System.out::println);
		
//		List<Stock> stockList=stockRepository.findByOrderByVolumeDesc();
//		System.out.println(stockList.size());
//		List<Stock> stockList=stockRepository.findThreeHighestVolumeStock(PageRequest.of(0, 3, Sort.by("volume").descending()));
//		Pageable pageable=PageRequest.of(0,3,Sort.by("volume").descending());
//		List<Stock> stockList=stockRepository.findThreeHighestVolumeStock(pageable);
//		stockList.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
//		service = context.getBean(CountryService.class);

//		testGetAllCountries();
//		testAddCountry();
//		testUpdateCountry();
//		 testDeleteCountry();
	}

//	public static void testGetAllCountries() {
//		LOGGER.info("Start");
//		List<Country> countryList = service.getAllCountries();
//		LOGGER.info("Countries : {} ", countryList);
//		try {
//			Country country = service.findCountryByCode("AF");
//			LOGGER.info("Countries : {} ", country);
//		} catch (CountryNotFoundException e) {
//			LOGGER.error(e.getMessage());
//		}
//
//		LOGGER.info("End");
//
//	}
//	
//	public static void testAddCountry() {
//		LOGGER.info("Start");
//		Country country= new Country("AA","New Country");
//		service.addCountry(country);
//		LOGGER.info("End");
//
//	}
//	public static void testUpdateCountry() {
//		LOGGER.info("Start");
//		try {
//		service.updateCountry("MM","New Country Modified");
//		} catch (CountryNotFoundException e) {
//			LOGGER.error(e.getMessage());
//		}
//		LOGGER.info("End");
//
//	}
//public static void testDeleteCountry() {
//	LOGGER.info("Start");
//	service.deleteCountry("MM");
//	LOGGER.info("End");
//}
//	
	
	
}