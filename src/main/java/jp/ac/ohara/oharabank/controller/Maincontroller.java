package jp.ac.ohara.oharabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.oharabank.model.Account;
import jp.ac.ohara.oharabank.model.UserModel;
import jp.ac.ohara.oharabank.service.AccountService;
import jp.ac.ohara.oharabank.service.UserService;

@Controller
public class Maincontroller {
	@Autowired
	private AccountService AccountService;
	@Autowired
	private UserService UserService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list",this.AccountService.getAddressList());
		return "top";
	}

	@GetMapping("/withdrawal")
	public ModelAndView add(Account account, ModelAndView model) {
		model.addObject("account", account);
		model.setViewName("withdrawal");
		return model;
	}

	@PostMapping("/withdrawal")
	public String complate(@Validated @ModelAttribute @NonNull Account account, RedirectAttributes result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.AccountService.save(account);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}

	@GetMapping("/payment")
	public ModelAndView ad(Account account, ModelAndView model) {
		model.addObject("account", account);
		model.setViewName("payment");
		return model;
		
	}

	@PostMapping("/payment")
	public String comp(@Validated @ModelAttribute @NonNull Account account, BindingResult result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.AccountService.save(account);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}
	@GetMapping("/update1/")
	  public void update1(Account account ,int updateMoney) {
	      int updatebank = account.getNyukin() ;
	      if (updatebank + updateMoney < 0) { 
	          new Exception();
	      }
	      int newBlance = updatebank + updateMoney;
	  }
	
	@GetMapping("/update2/")
	  public void update2(Account account ,int updateMoney) {
	      int updatebank = account.getNyukin() ;
	      if (updatebank + updateMoney < 0) { 
	          new Exception();
	      }
	      int newBlance = updatebank - updateMoney;
	}

	  
	
	@GetMapping("/login")
	public ModelAndView in(UserModel user ,ModelAndView model) {
		model.addObject("login", user);
		model.setViewName("login");
		return model;
}

	
	@GetMapping("/signup")
	public ModelAndView i(UserModel users ,ModelAndView model) {
		model.addObject("signup", users);
		model.setViewName("signup");
		return model;
}
	
	@PostMapping("/signup")
	public String c(@Validated @ModelAttribute @NonNull UserModel usermodel, BindingResult result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.UserService.save(usermodel);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:login";
}
}
