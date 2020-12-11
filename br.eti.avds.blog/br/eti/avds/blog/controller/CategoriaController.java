package br.eti.avds.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.CategoriaDao;
import br.eti.avds.blog.dao.TagDao;
import br.eti.avds.blog.model.Categoria;
import br.eti.avds.blog.model.Tag;

@Controller
public class CategoriaController {
	@RequestMapping("/categoria/index")
	public String index(Model model) {
		CategoriaDao dao = new CategoriaDao();
		List<Categoria> categorias = dao.getAll();
		model.addAttribute("categorias", categorias);
		return "/categoria/index";
	}
	
	
	@RequestMapping("/categoria/add")
	public String add(HttpServletRequest request) {
		if(request.getMethod().equals("POST")){//está salvando
			Categoria categoria = new Categoria(request.getParameter("nome"));
			CategoriaDao dao = new CategoriaDao();
			dao.save(categoria);
			return "redirect:/categoria/index";
		}
		return "/categoria/add";
	}
	
	
	@RequestMapping("/categoria/edit")
	public String edit(HttpServletRequest request, Model model) {
		CategoriaDao dao = new CategoriaDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = dao.get(id);
		if(request.getMethod().equals("POST")){//está salvando
			categoria.setNome(request.getParameter("nome"));
			dao.update(categoria);
			return "redirect:/categoria/index";
		}
		model.addAttribute("categoria", categoria);
		return "/categoria/edit";
	}
	
	
	@RequestMapping("/categoria/delete")
	public String delete(HttpServletRequest request) {
		CategoriaDao dao = new CategoriaDao();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/categoria/index";
	}	
}
