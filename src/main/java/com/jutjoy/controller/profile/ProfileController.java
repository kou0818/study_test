package com.jutjoy.controller.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jutjoy.domain.entity.profile.Profile;
import com.jutjoy.domain.form.profile.ProfileCreateForm;
import com.jutjoy.domain.service.profile.ProfileCreateService;
import com.jutjoy.domain.service.profile.ProfileListService;

@Controller
public class ProfileController {
	
	@GetMapping("/profile/create")
	public String create(@ModelAttribute("form") ProfileCreateForm ProfileCreateForm) {
		return "profile/create";
	}
	
	@Autowired
	private ProfileCreateService ProfileCreateService;
	
	@PostMapping("/profile/create")
	public String create(@Validated @ModelAttribute("form") ProfileCreateForm ProfileCreateForm,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "profile/create";
		}
		
		ProfileCreateService.create(ProfileCreateForm);
		
		return "redirect:/profile/create/complete";
	}
	
	// 2-5課題で編集
	@GetMapping("/profile/{action}/complete")
	public String complete(@PathVariable(name = "action") String action, Model model) {
		return "profile/complete";
	}
	
	//2-4で追記
	@Autowired
	private ProfileListService profileListService;
	
	@GetMapping("/profile/list")
	public String list(@RequestParam(name = "name", required = false) String name, Model model) {
		
		List<Profile> profileList = profileListService.list(name);
		model.addAttribute("profileList", profileList);
		model.addAttribute("name", name);
		
		return "profile/list";
	}
}