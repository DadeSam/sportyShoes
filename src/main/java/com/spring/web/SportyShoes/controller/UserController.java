//userController Class
package com.spring.web.SportyShoes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.web.SportyShoes.entity.User;
import com.spring.web.SportyShoes.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
    public String homepage() {
        return "index";
    }

	@GetMapping("/AdminDashboard")
    public String formAdminDashboard() {	
        return "AdminDashboard";
    }
    @PostMapping("/Login")
    public String adminLogin(@RequestParam ("username")String username,
    						@RequestParam("password")String password, Model model) {
		if (userService.validateUser(username, password)){
			model.addAttribute("username", username);
			
			return "AdminDashboard";
		}else {
			System.out.println("Invalid username or password");
			model.addAttribute("errorMessage","Invalid username or password");
			return "/index"; 
		}     
    }
 
	@GetMapping("/ViewUser")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "ViewUser";
	}
	 
	@GetMapping("/ViewUser/search")
	public String searchUser(@RequestParam("username") String username, Model model) {
	    User user = userService.findByUsername(username);
	    if (user != null) {
	    	model.addAttribute("searchResult", user);
	    }
	    model.addAttribute("users", userService.getAllUsers());
	    return "ViewUser";
	}
	
	@GetMapping("/ChangePassword")
	public String changePassword() {
		return "ChangePassword";}
	
	@PostMapping("/ResetPassword")
	public String resetPassword(@RequestParam ("username")String username,
								@RequestParam("newPassword")String newPassword,
								@RequestParam("confirmPassword")String confirmPassword,
								Model model) {
		
		 User user = userService.findByUsername(username);
		
		 if (user != null && user.getUsername().equals(username) && newPassword.equals(confirmPassword)) {
		        userService.updatePassword(username, newPassword);
		        model.addAttribute("successMessage", "Password changed successfully. Please login with the new password");
		        return "index";
		    } else {
		        model.addAttribute("errorMessage", "Invalid username or confirm password does not match");
		        return "ChangePassword";
		    }
		}
	}