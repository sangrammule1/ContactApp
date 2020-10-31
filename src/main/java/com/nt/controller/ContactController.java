package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.domain.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService service;

	@GetMapping("/showForm")
	public String showForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact_form";
	}

	@PostMapping("/showForm")
	public String saveContact(RedirectAttributes attribute, @ModelAttribute("contact") Contact contact) {

		// use service
		boolean saveContact = service.saveContact(contact);
		if (saveContact) {
			attribute.addFlashAttribute("Saved", "contact saved");
		} else {
			attribute.addFlashAttribute("Saved", "contact not saved");
		}
		return "redirect:/contactSaveSuccess";
	}
	
	@RequestMapping(value = "/contactSaveSuccess")
	public String saveContactSuccess(Model model) {
		model.addAttribute("contact", new Contact());
		return  "contact_form";
	}
	
	@RequestMapping("/showAllContact")
	public String showAllContacts(Model model) {
		//use service
		List<Contact> contacts = service.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "all_contacts";
	}
	
	@GetMapping("/updateContact")
	public String updateContact(Model model,HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("contactId"));
		//use service
		Contact contact = service.getContactById(id);
		model.addAttribute("contact",contact);
		return "contact_form";
	}
	
	@PostMapping("/updateContact")
	public String updateContact(Model model,@ModelAttribute("contact") Contact contact) {
		//use service
		boolean saveContact = service.saveContact(contact);
		if(saveContact) {
			model.addAttribute("Saved","contact updated");
		} else {
			model.addAttribute("Saved","contact not updated");
		}
		List<Contact> contacts = service.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "all_contacts";
	}
	
	@RequestMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam("email") String email) {
		return service.validateEmail(email);
	}

	@RequestMapping("/deleteContact")
	public String deleteContact(Model model,HttpServletRequest req,@ModelAttribute("contact") Contact contact) {
		Integer id=Integer.parseInt(req.getParameter("contactId"));
		boolean isDelete = service.deleteContactById(id);
		if(isDelete) {
			model.addAttribute("delete","contact deleted");
		} else {
			model.addAttribute("delete","contact not deleted");
		}
		List<Contact> contacts = service.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "all_contacts";
	}
}
