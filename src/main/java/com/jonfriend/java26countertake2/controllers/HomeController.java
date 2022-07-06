//find/replace instances of 'java22displaydate' with trueName of project
package com.jonfriend.java26countertake2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.time.LocalDateTime; 
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat; 
import java.util.ArrayList; 

//import Item.java; 
import com.jonfriend.java26countertake2.models.Item;

@Controller

public class HomeController {
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		
//		String fruitx = "apple"; 
//		
//		model.addAttribute("fruity", fruitx); 
//		return "index.jsp"; 
		
		String customerName = "Buzz Aldrin"; 
		String itemName = "Rolled Flag"; 
		double itemPrice = 100000.00; 
		String itemDescription = "Symbol of freedom and prosperity"; 
		String vendorName = "Northrup Grummon"; 
		
		
		model.addAttribute("customerName", customerName); 
		model.addAttribute("itemName", itemName); 
		model.addAttribute("itemPrice", itemPrice); 
		model.addAttribute("itemDescription", itemDescription); 
		model.addAttribute("vendorName", vendorName); 
		
		ArrayList<Item> fruitsArrList = new ArrayList<Item>();
		fruitsArrList.add(new Item("Kiwi", 1.5));
		fruitsArrList.add(new Item("Mango", 2.0));
		fruitsArrList.add(new Item("Goji Berries", 4.0));
		fruitsArrList.add(new Item("Guava", .75));
		
        model.addAttribute("fruitsFromHomeController", fruitsArrList);
        
//        session.setAttribute("count", 0);
        
        if (session.getAttribute("count") == null) {
    		// Use setAttribute to initialize the count in session
        	session.setAttribute("count", 0);
    	} else {
    		// increment the count by 1 using getAttribute and setAttribute
//    		session.count = session.getAttribute("count") += 1; 
    		Integer currentCount = (Integer) session.getAttribute("count");
    		currentCount ++; 
    		session.setAttribute("count", currentCount); 
    		}
        
		return "index.jsp"; 
	}

	
	@RequestMapping("/counter")
	public String counterApp(Model model, HttpSession session, HttpServletRequest request) {
		Integer currentCount = 0; 
		if (session.getAttribute("count") == null) {
    		// Use setAttribute to initialize the count in session
        	session.setAttribute("count", 0);
    	} else {
    		// increment the count by 1 using getAttribute and setAttribute
//    		session.count = session.getAttribute("count") += 1; 
    		currentCount = (Integer) session.getAttribute("count");
    	}
		
		// we can use the following line to get the URL of our page, in this case http://localhost:8080/counter/
		String homeUrl = request.getRequestURL().toString();
		
		model.addAttribute("countToShow", currentCount);
		
		model.addAttribute("page", homeUrl.substring(0,homeUrl.length()-9)); 
		return "counter.jsp"; 
	}
	
	@RequestMapping("/date")
	public String dateRoute(Model model) {
		

		// JRF: below my 1st attempt
		LocalDateTime myDateObj = LocalDateTime.now(); // Create a date object
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
		String formattedDate = myDateObj.format(myFormatObj);
		model.addAttribute("displayDate", formattedDate);
		// JRF end
		
		SimpleDateFormat dayName = new SimpleDateFormat("EEEE");
		SimpleDateFormat dayOfMonth = new SimpleDateFormat("dd");
		SimpleDateFormat spelledOutMonth = new SimpleDateFormat("MMMM");
		SimpleDateFormat yearFourNums = new SimpleDateFormat("Y");
		
		Date dateObj = new Date(); 
		
		String dayNameString = dayName.format(dateObj); 
		String dayOfMonthString = dayOfMonth.format(dateObj); 
		String spelledOutMonthString = spelledOutMonth.format(dateObj); 
		String yearFourNumsString = yearFourNums.format(dateObj); 
		
		String comprehensiveDateString = dayNameString + ", the " + dayOfMonthString + " of "  + spelledOutMonthString + ", " + yearFourNumsString + " "; 
		
		model.addAttribute("displayDate2", comprehensiveDateString);
		
		
		return "date.jsp"; 
	}

	@RequestMapping("/time")
	public String timeRoute(Model model) {
		
		SimpleDateFormat easyTime = new SimpleDateFormat("h:mm a");
		
		Date dateObj = new Date(); 
		
		String easyTimeString = easyTime.format(dateObj); 
		
//		String comprehensiveDateString = dayNameString + ", the " + dayOfMonthString + " of "  + spelledOutMonthString + ", " + yearFourNumsString + " "; 
		
		model.addAttribute("displayTime", easyTimeString);
		
		return "time.jsp"; 
	}
	
	@RequestMapping("/dojos")
    public String dojosRoute(Model model) {
        ArrayList<String> dojosArrList = new ArrayList<String>();
        dojosArrList.add("Burbank");
        dojosArrList.add("Chicago");
        dojosArrList.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojosArrList);
        return "dojos.jsp";
    }
	
	//	@RequestMapping("")
//	public String hello() {
//		return "19 Welcome!"; 
//	}
	
//	@RequestMapping("/today")
//	public String today() {
//		return "19 Today you will find luck in all your endeavors!"; 
//	}
//	
//	@RequestMapping("/tomorrow")
//	public String tommy() {
//		return "19 Tomorrow, an opportunity will arise, so be sure to be open to new ideas!"; 
//	}
//	
//	@RequestMapping("/travel")
//	public String travvy0() {
//		return "19 You want to get away, I get it."; 
//	}
//	
//	@RequestMapping("/travel/{destination}")
//	public String travvy(@PathVariable("destination") String destination) {
//		return "19 Congrats!  You will soon travel to " + destination + "!" ; 
//	}
//	
//	@RequestMapping("/lotto")
//	public String lotty0() {
//		return "19 get some advice here, dude."; 
//	}
//	
//	@RequestMapping("/lotto/{intyInt}")
//	public String lotty(@PathVariable("intyInt") Integer intyInt) {
//		if (intyInt % 2 == 0) {
//			return "You will take a grand journey in the near future, but be weary of tempting offers."; 
//		} else {
//			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."; 
//		}
//		
//		 
//	}
}
