package com.monstersoftwarellc.springjpatemplate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monstersoftwarellc.springjpatemplate.dao.IAccountDAO;
import com.monstersoftwarellc.springjpatemplate.model.Account;
import com.monstersoftwarellc.springjpatemplate.model.Account_;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IAccountDAO accountDAO;
	
	@RequestMapping(value="/addUser")
	public String home(Model model) {
		Account account = new Account();
		model.addAttribute("account", account );		
		return "createUser";
	}
	
	/**
	 * NOTE: when performing {@Valid} you need to ensure the BindingResult is next in the parameter list.
	 * ALSO: @Valid can take the place of @ModelAttribute as well, so no need to specify that 
	 * @param person
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String createUser(@Valid Account account, BindingResult result, Model model){
		// if errors stay on createUser page. 
		if(result.hasErrors()) {
			 return "createUser";
		}
		accountDAO.persist(account);
		// easy forwarding! 
		return listUsers(model);
	}
	
	@RequestMapping("/listUsers")
	public String listUsers(Model model) { 
		model.addAttribute("accounts", accountDAO.findAllOrderBy(Account_.id));
		return "listUsers"; 
	}
	
}
