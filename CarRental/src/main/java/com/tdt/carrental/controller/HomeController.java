package com.tdt.carrental.controller;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tdt.carrental.model.Car;
import com.tdt.carrental.model.Customer;
import com.tdt.carrental.model.Driver;
import com.tdt.carrental.model.Schedule;
import com.tdt.carrental.model.ShoppingCart;
import com.tdt.carrental.model.TicketFare;
import com.tdt.carrental.model.User;
import com.tdt.carrental.services.CarServices;
import com.tdt.carrental.services.CustomerServices;
import com.tdt.carrental.services.DriverSevices;
import com.tdt.carrental.services.ScheduleServices;
import com.tdt.carrental.services.ShoppingCartServices;
import com.tdt.carrental.services.TicketFareServices;
import com.tdt.carrental.services.UserServices;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private UserServices userServices;

	@Autowired
	private DriverSevices driverServices;

	@Autowired
	private CarServices carServices;

	@Autowired
	private ScheduleServices scheduleServices;
	
	@Autowired
	private TicketFareServices ticketFareServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private ShoppingCartServices shoppingCartServices;
	
	private static int passCodeRandom;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		passCodeRandom = 0;
		model.addAttribute("user", new User());
		model.addAttribute("registration", new User());
		return "Login";
	}

	/* CHECK LOGIN TRUE OR FALSE */
	@RequestMapping(value = "/Check-Login", method = RequestMethod.POST)
	public String checkLogin(@Validated @ModelAttribute("user") User user, Model model,
			RedirectAttributes redirectAttributes) {
		Random random = new Random();
		int randomNumber = random.nextInt(9000) + 1000;
		passCodeRandom = randomNumber;
		if (this.userServices.checkLogIn(user) == true) {
			redirectAttributes.addFlashAttribute("passCode", randomNumber);
			return "redirect:/DriverList";
		}
		return "redirect:/";
	}

	/* REGISTRATION USER */
	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public String registration(@Validated @ModelAttribute("registration") User signUp) {
		if (this.userServices.signUp(signUp) == true) {
			return "home";
		} else {
			return "redirect:/";
		}
	}

	/* SHOW LIST DRIVER */
	@RequestMapping(value = "/DriverList")
	public String driverList(Model model) {
		int passCode = (Integer) model.asMap().get("passCode");
		if (passCode == passCodeRandom) {
			List<Driver> DriverList = this.driverServices.listDriver();
			model.addAttribute("passCode", passCode);
			model.addAttribute("driverList", DriverList);
			return "Driver";
		} else {
			return "redirect:/";
		}
	}

	/* SHOW LIST DRIVER */
	@RequestMapping(value = "/DriverList/{passCode}")
	public String driverListRefresh(@PathVariable int passCode, Model model) {
		if (passCodeRandom == passCode) {
			List<Driver> driverList = this.driverServices.listDriver();
			model.addAttribute("passCode", passCode);
			model.addAttribute("driverList", driverList);
			return "Driver";

		} else {
			return "redirect:/";
		}
	}

	/* SHOW VIEW NEW DRIVER */
	@RequestMapping(value = "/ShowNewDriver")
	public String showNewDriver(Model model) {
		model.addAttribute("registrationDriver", new Driver());
		model.addAttribute("action", "/RegistrationDriver");
		model.addAttribute("attribute", "registrationDriver");
		return "NewDriver";
	}

	/* REGISTRATION DRIVER */
	@RequestMapping(value = "/RegistrationDriver", method = RequestMethod.POST)
	public String registrationDriver(@Validated @ModelAttribute("registrationDriver") Driver signUp) {
		if (this.driverServices.signUp(signUp) == true) {
			return "redirect:/DriverList/" + passCodeRandom;
		} else {
			return "redirect:/";
		}
	}

	/*---GET DRIVER BY ID---------*/
	@RequestMapping(value = "/Get-Driver/{id}")
	public String getDevice(@PathVariable Long id, Model model) {
		Driver driver = this.driverServices.getDriver(id);
		model.addAttribute("driver", driver);
		model.addAttribute("action", "/Edit-Save-Driver");
		model.addAttribute("attribute", "driver");
		return "NewDriver";
	}

	/* SAVE DRIVER AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-Driver", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("driver") Driver driver) {
		if (this.driverServices.updateDriver(driver) == true) {
			return "redirect:/DriverList/" + passCodeRandom;
		}
		return "home";
	}

	/* SHOW VIEW NEW CAR */
	@RequestMapping(value = "/ShowNewCar")
	public String showNewCar(Model model) {
		List<Driver> driverList = this.driverServices.listDriver();
		model.addAttribute("registrationCar", new Car());
		model.addAttribute("driverList", driverList);
		model.addAttribute("action", "/RegistrationCar");
		model.addAttribute("attribute", "registrationCar");
		return "NewCar";
	}

	/* REGISTRATION CAR */
	@RequestMapping(value = "/RegistrationCar", method = RequestMethod.POST)
	public String registrationCar(@Validated @ModelAttribute("registrationCar") Car signUp) {
		if (this.carServices.signUp(signUp) == true) {
			return "redirect:/CarList/" + passCodeRandom;
		} else {
			return "redirect:/";
		}
	}

	/*---GET CAR BY ID---------*/
	@RequestMapping(value = "/Get-Car/{id}")
	public String getCar(@PathVariable String id, Model model) {
		List<Driver> driverList = this.driverServices.listDriver();
		Car car = this.carServices.getCar(id);
		model.addAttribute("car", car);
		model.addAttribute("driverList", driverList);
		model.addAttribute("action", "/Edit-Save-Car");
		model.addAttribute("attribute", "car");
		return "NewCar";
	}

	/* SAVE CAR AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-Car", method = RequestMethod.POST)
	public String saveEditCar(@ModelAttribute("car") Car car) {
		if (this.carServices.updateCar(car) == true) {
			return "redirect:/CarList/" + passCodeRandom;
		}
		return "home";
	}

	/* SHOW LIST CAR */
	@RequestMapping(value = "/CarList/{passCode}")
	public String carList(@PathVariable int passCode, Model model) {
		if (passCodeRandom == passCode) {
			List<Car> carList = this.carServices.listCar();
			model.addAttribute("passCode", passCode);
			model.addAttribute("carList", carList);
			return "Car";

		} else {
			return "redirect:/";
		}
	}

	/* SHOW VIEW NEW SCHEDULE */
	@RequestMapping(value = "/ShowNewSchedule")
	public String showNewSchedule(Model model) {
		List<Car> carList = this.carServices.listCar();
		model.addAttribute("registrationSchedule", new Schedule());
		model.addAttribute("carList", carList);
		model.addAttribute("action", "/RegistrationSchedule");
		model.addAttribute("attribute", "registrationSchedule");
		return "NewSchedule";
	}

	/* REGISTRATION SCHEDULE */
	@RequestMapping(value = "/RegistrationSchedule", method = RequestMethod.POST)
	public String registrationCar(@Validated @ModelAttribute("registrationSchedule") Schedule schedule) {
		if (this.scheduleServices.registrationSchedule(schedule) == true) {
			return "redirect:/ScheduleList/" + passCodeRandom;
		} else {
			return "redirect:/";
		}
	}

	/*---GET SCHEDULE BY ID---------*/
	@RequestMapping(value = "/Get-Schedule/{id}")
	public String getSchedule(@PathVariable int id, Model model) {
		List<Car> carList = this.carServices.listCar();
		Schedule schedule = this.scheduleServices.getSchedule(id);
		model.addAttribute("schedule", schedule);
		model.addAttribute("carList", carList);
		model.addAttribute("action", "/Edit-Save-Schedule");
		model.addAttribute("attribute", "schedule");
		return "NewSchedule";
	}

	/* SAVE SCHEDULE AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-Schedule", method = RequestMethod.POST)
	public String saveEditCar(@ModelAttribute("schedule") Schedule schedule) {
		if (this.scheduleServices.updateSchedule(schedule) == true) {
			return "redirect:/ScheduleList/" + passCodeRandom;
		}
		return "home";
	}

	/* SHOW LIST SCHEDULE */
	@RequestMapping(value = "/ScheduleList/{passCode}")
	public String scheduleList(@PathVariable int passCode, Model model) {
		if (passCodeRandom == passCode) {
			List<Schedule> scheduleList = this.scheduleServices.listSchedule();
			model.addAttribute("passCode", passCode);
			model.addAttribute("scheduleList", scheduleList);
			return "Schedule";

		} else {
			return "redirect:/";
		}
	}

	/* SHOW VIEW NEW TICKET-FARE */
	@RequestMapping(value = "/ShowNewTicketFare")
	public String showNewTicketFare(Model model) {
		List<Schedule> scheduleList = this.scheduleServices.listSchedule();
		List<Car> carList = this.carServices.listCar();
		model.addAttribute("registrationTicketFare", new TicketFare());
		model.addAttribute("scheduleList", scheduleList);
		model.addAttribute("carList", carList);
		model.addAttribute("action", "/RegistrationTicketFare");
		model.addAttribute("attribute", "registrationTicketFare");
		return "NewTicketFare";
	}

	/* REGISTRATION TICKET-FARE */
	@RequestMapping(value = "/RegistrationTicketFare", method = RequestMethod.POST)
	public String registrationTicketFare(@Validated @ModelAttribute("registrationTicketFare") TicketFare ticketFare) {
		if (this.ticketFareServices.registrationTicketFare(ticketFare) == true) {
			return "redirect:/TicketFareList/" + passCodeRandom;
		} else {
			return "redirect:/";
		}
	}

	/*---GET TICKET-FARE BY ID---------*/
	@RequestMapping(value = "/Get-TicketFare/{id}")
	public String getTicketFare(@PathVariable int id, Model model) {
		List<Schedule> scheduleList = this.scheduleServices.listSchedule();
		List<Car> carList = this.carServices.listCar();
		TicketFare ticketFare = this.ticketFareServices.getTicketFare(id);
		model.addAttribute("ticketFare", ticketFare);
		model.addAttribute("scheduleList", scheduleList);
		model.addAttribute("carList", carList);
		model.addAttribute("action", "/Edit-Save-TicketFare");
		model.addAttribute("attribute", "ticketFare");
		return "NewTicketFare";
	}

	/* SAVE TICKET-FARE AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-TicketFare", method = RequestMethod.POST)
	public String saveEditCar(@ModelAttribute("ticketFare") TicketFare ticketFare) {
		if (this.ticketFareServices.updateTicketFare(ticketFare) == true) {
			return "redirect:/TicketFareList/" + passCodeRandom;
		}
		return "home";
	}

	/* SHOW LIST TICKET-FARE */
	@RequestMapping(value = "/TicketFareList/{passCode}")
	public String ticketFareListList(@PathVariable int passCode, Model model) {
		if (passCodeRandom == passCode) {
			List<TicketFare> ticketFareList = this.ticketFareServices.listTicketFare();
			model.addAttribute("passCode", passCode);
			model.addAttribute("ticketFareList", ticketFareList);
			return "TicketFare";

		} else {
			return "redirect:/";
		}
	}
	
	/* SHOW VIEW NEW CUSTOMER */
	@RequestMapping(value = "/ShowNewCustomer")
	public String showNewCustomer(Model model) {
		model.addAttribute("registrationCustomer", new Customer());
		model.addAttribute("action", "/RegistrationCustomer");
		model.addAttribute("attribute", "registrationCustomer");
		return "NewCustomer";
	}

	/* REGISTRATION CUSTOMER */
	@RequestMapping(value = "/RegistrationCustomer", method = RequestMethod.POST)
	public String registrationCustomer(@Validated @ModelAttribute("registrationCustomer") Customer customer) {
		if (this.customerServices.registrationCustomer(customer) == true) {
			return "redirect:/CustomerList/" + passCodeRandom;
		} else {
			return "redirect:/";
		}
	}

	/*---GET CUSTOMER BY ID---------*/
	@RequestMapping(value = "/Get-Customer/{tel}")
	public String getCustomer(@PathVariable String tel, Model model) {
		Customer customer = this.customerServices.getCustomer(tel);
		model.addAttribute("customer", customer);
		model.addAttribute("action", "/Edit-Save-Customer");
		model.addAttribute("attribute", "customer");
		return "NewTicketFare";
	}

	/* SAVE TICKET-FARE AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-Customer", method = RequestMethod.POST)
	public String saveEditCustomer(@ModelAttribute("customer") Customer customer) {
		if (this.customerServices.updateCustomer(customer) == true) {
			return "redirect:/CustomerList/" + passCodeRandom;
		}
		return "home";
	}

	/* SHOW LIST CUSTOMER */
	@RequestMapping(value = "/CustomerList/{passCode}")
	public String customerList(@PathVariable int passCode, Model model) {
		if (passCodeRandom == passCode) {
			List<Customer> customerList = this.customerServices.listCustomer();
			model.addAttribute("passCode", passCode);
			model.addAttribute("customerList", customerList);
			return "Customer";

		} else {
			return "redirect:/";
		}
	}
	/* SHOW VIEW NEW SHOPPING CART */
	@RequestMapping(value = "/ShowNewShoppingCart")
	public String showNewShoppingCart(Model model) {
		model.addAttribute("registrationShoppingCart", new ShoppingCart());
		model.addAttribute("action", "/RegistrationShoppingCart");
		model.addAttribute("attribute", "registrationShoppingCart");
		return "NewShoppingCart";
	}

	/* REGISTRATION CUSTOMER */
	@RequestMapping(value = "/RegistrationShoppingCart", method = RequestMethod.POST)
	public String registrationShoppingCart(@Validated @ModelAttribute("registrationShoppingCart") ShoppingCart shoppingCart) {
		if (this.shoppingCartServices.registrationShoppingCart(shoppingCart) == true) {
			return "redirect:/ShoppingCartList/" + passCodeRandom;
		} else {
			return "redirect:/";
		}
	}

	/*---GET SHOPPING CART BY ID---------*/
	@RequestMapping(value = "/Get-ShoppingCart/{id}")
	public String getShoppingCart(@PathVariable int id, Model model) {
		ShoppingCart shoppingCart = this.shoppingCartServices.getShoppingCart(id);
		model.addAttribute("shoppingCart", shoppingCart);
		model.addAttribute("action", "/Edit-Save-ShoppingCart");
		model.addAttribute("attribute", "shoppingCart");
		return "NewTicketFare";
	}

	/* SAVE TICKET-FARE AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-ShoppingCart", method = RequestMethod.POST)
	public String saveEditShoppingCart(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart) {
		if (this.shoppingCartServices.updateShoppingCart(shoppingCart) == true) {
			return "redirect:/ShoppingCartList/" + passCodeRandom;
		}
		return "home";
	}

	/* SHOW LIST CUSTOMER */
	@RequestMapping(value = "/ShoppingCartList/{passCode}")
	public String shoppingCartList(@PathVariable int passCode, Model model) {
		if (passCodeRandom == passCode) {
			List<ShoppingCart> shoppingCartList = this.shoppingCartServices.listShoppingCart();
			model.addAttribute("passCode", passCode);
			model.addAttribute("shoppingCartList", shoppingCartList);
			return "ShoppingCart";

		} else {
			return "redirect:/";
		}
	}
	/* Test */
	@RequestMapping(value = "/test")
	public String test(Model model) {
		model.addAttribute("newDriver", new Driver());
		return "NewDriver";
	}
}
