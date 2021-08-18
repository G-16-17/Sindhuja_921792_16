package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		menuItemService = context.getBean(MenuItemService.class);

		LOGGER.info("Inside Main.....");

		getAdminList();
		//getCustomerList();
		//modifyMenuItemList();
		//testAddMenuItem();
	}

	private static void getAdminList() {
		LOGGER.info("Start");
		List<MenuItem> menuItemsList = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Items= {}", menuItemsList);
		LOGGER.info("End");
	}

	private static void getCustomerList() {
		LOGGER.info("Start");
		List<MenuItem> menuItemsList = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Items= {}", menuItemsList);
		LOGGER.info("End");

	}

	private static void modifyMenuItemList() {
		LOGGER.info("Start");
		MenuItem newItem = new MenuItem(1003, "Nuggets", 99, true, DateUtil.convertToDate("21/08/2007"),
				"Main Course", true);
		menuItemService.addMenuItem(newItem);
		LOGGER.debug("Items= {}", newItem);
		LOGGER.info("End");


	}
	private static void testAddMenuItem() {
		LOGGER.info("Start");
		MenuItem newItem = new MenuItem(6, "Pav Baji", 180, true, DateUtil.convertToDate("07/02/2000"),
				"Main Course", true);
		menuItemService.addMenuItem(newItem);
		LOGGER.debug("Items= {}", newItem);
		LOGGER.info("End");

	}
}