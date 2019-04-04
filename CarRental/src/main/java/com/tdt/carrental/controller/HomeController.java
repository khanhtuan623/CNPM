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
import com.tdt.carrental.model.Driver;
import com.tdt.carrental.model.User;
import com.tdt.carrental.services.CarServices;
import com.tdt.carrental.services.DriverSevices;
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
	
	private static int passCodeRandom;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
			passCodeRandom=0;
			model.addAttribute("user", new User() );
			model.addAttribute("registration",new User());
			return "Login";
		}
	/*CHECK LOGIN TRUE OR FALSE*/
	@RequestMapping(value = "/Check-Login", method = RequestMethod.POST)
	public String checkLogin(@Validated @ModelAttribute("user") User user,Model model,RedirectAttributes redirectAttributes) {
			Random random = new Random();
			int randomNumber = random.nextInt(9000) + 1000;
			passCodeRandom=randomNumber;
			if(this.userServices.checkLogIn(user)==true) {
				redirectAttributes.addFlashAttribute("passCode",randomNumber);
				return "redirect:/DriverList";
			}
			return "redirect:/";
		}
	/*REGISTRATION USER*/
	@RequestMapping(value = "/Registration",method=RequestMethod.POST)
	public String registration(@Validated @ModelAttribute("registration") User signUp) {
			if(this.userServices.signUp(signUp)==true) {
				return "home";
			}
			else {
				return "redirect:/";
			}
		}
	/*SHOW LIST DRIVER*/
	@RequestMapping(value="/DriverList")
	public String driverList(Model model){
		int passCode=(Integer) model.asMap().get("passCode");
		if(passCode==passCodeRandom) {
		List<Driver>DriverList=this.driverServices.listDriver();
		model.addAttribute("passCode",passCode);
		model.addAttribute("driverList", DriverList);
		return "Driver";
		}
		else {
			return "redirect:/";
		}
	}
	/*SHOW LIST DRIVER*/
	@RequestMapping(value="/DriverList/{passCode}")
	public String driverListRefresh(@PathVariable int passCode,Model model){
		if(passCodeRandom==passCode) {
			List<Driver>driverList=this.driverServices.listDriver();
			model.addAttribute("passCode",passCode);
			model.addAttribute("driverList", driverList);
			return "Driver";

		}
		else {
			return "redirect:/";
		}
	}
	/*SHOW VIEW NEW DRIVER*/
	@RequestMapping(value="/ShowNewDriver")
	public String showNewDriver(Model model) {
		model.addAttribute("registrationDriver", new Driver());
		model.addAttribute("action", "/RegistrationDriver");
		model.addAttribute("attribute", "registrationDriver");
		return "NewDriver";
	}
	/*REGISTRATION DRIVER*/
	@RequestMapping(value = "/RegistrationDriver",method=RequestMethod.POST)
	public String registrationDriver(@Validated @ModelAttribute("registrationDriver") Driver signUp) {
			if(this.driverServices.signUp(signUp)==true) {
				return "redirect:/DriverList/"+passCodeRandom;
			}
			else {
				return "redirect:/";
			}
		}
	/*---GET Driver BY ID---------*/
	@RequestMapping(value = "/Get-Driver/{id}")
	public String getDevice(@PathVariable Long id, Model model) {
		Driver driver = this.driverServices.getDriver(id);
		model.addAttribute("driver", driver);
		model.addAttribute("action", "/Edit-Save-Driver");
		model.addAttribute("attribute", "driver");
		return "NewDriver";
	}
	/* SAVE DEVICE AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-Driver", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("driver") Driver driver) {
		if (this.driverServices.updateDriver(driver) == true) {
			return "redirect:/DriverList/"+passCodeRandom;
		}
		return "home";
	}
	/*SHOW VIEW NEW Car*/
	@RequestMapping(value="/ShowNewCar")
	public String showNewCar(Model model) {
		List<Driver>driverList=this.driverServices.listDriver();
		model.addAttribute("registrationCar", new Car());
		model.addAttribute("driverList", driverList);
		model.addAttribute("action", "/RegistrationCar");
		model.addAttribute("attribute", "registrationCar");
		return "NewCar";
	}
	/*REGISTRATION Car*/
	@RequestMapping(value = "/RegistrationCar",method=RequestMethod.POST)
	public String registrationCar(@Validated @ModelAttribute("registrationCar") Car signUp) {
			if(this.carServices.signUp(signUp)==true) {
				return "redirect:/CarList/"+passCodeRandom;
			}
			else {
				return "redirect:/";
			}
		}
	/*---GET Car BY ID---------*/
	@RequestMapping(value = "/Get-Car/{id}")
	public String getCar(@PathVariable String id, Model model) {
		List<Driver>driverList=this.driverServices.listDriver();
		Car car = this.carServices.getCar(id);
		model.addAttribute("car", car);
		model.addAttribute("driverList", driverList);
		model.addAttribute("action", "/Edit-Save-Car");
		model.addAttribute("attribute", "car");
		return "NewCar";
	}
	/* SAVE Car AFTER EDIT */
	@RequestMapping(value = "/Edit-Save-Car", method = RequestMethod.POST)
	public String saveEditCar(@ModelAttribute("car") Car car) {
		if (this.carServices.updateCar(car) == true) {
			return "redirect:/CarList/"+passCodeRandom;
		}
		return "home";
	}
	/*SHOW LIST CAR*/
	@RequestMapping(value = "/CarList/{passCode}")
	public String carList(@PathVariable int passCode, Model model) {
		if(passCodeRandom==passCode) {
			System.out.println("ok");
			List<Car>carList=this.carServices.listCar();
			model.addAttribute("passCode",passCode);
			model.addAttribute("carList", carList);
			return "Car";

		}
		else {
			return "redirect:/";
		}
	}
	/*Test*/
	@RequestMapping(value="/test")
	public String test(Model model) {
		model.addAttribute("newDriver",new Driver());
		return "NewDriver";
	}
}
