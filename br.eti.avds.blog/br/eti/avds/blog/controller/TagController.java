package br.eti.avds.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.TagDao;
import br.eti.avds.blog.model.Tag;

@Controller
public class TagController {
	@RequestMapping("/tag/index")
	public String index(Model model) {
		TagDao dao = new TagDao();
		List<Tag> tags = dao.getAll();
		model.addAttribute("tags", tags);
		return "/tag/index";
	}
	
	
	@RequestMapping("/tag/add")
	public String add(HttpServletRequest request) {
		if(request.getMethod().equals("POST")){//está salvando
			Tag tag = new Tag(request.getParameter("nome"));
			TagDao dao = new TagDao();
			dao.save(tag);
			return "redirect:/tag/index";
		}
		return "/tag/add";
	}
	
	
	@RequestMapping("/tag/edit")
	public String edit(HttpServletRequest request, Model model) {
		TagDao dao = new TagDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Tag tag = dao.get(id);
		if(request.getMethod().equals("POST")){//está salvando
			tag.setNome(request.getParameter("nome"));
			dao.update(tag);
			return "redirect:/tag/index";
		}
		model.addAttribute("tag", tag);
		return "/tag/edit";
	}
	
	
	@RequestMapping("/tag/delete")
	public String delete(HttpServletRequest request) {
		TagDao dao = new TagDao();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/tag/index";
	}	
}
