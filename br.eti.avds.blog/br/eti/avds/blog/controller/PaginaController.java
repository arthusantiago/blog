package br.eti.avds.blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.AutorDao;
import br.eti.avds.blog.dao.PaginaDao;
import br.eti.avds.blog.dao.PostDao;
import br.eti.avds.blog.dao.TagDao;
import br.eti.avds.blog.dao.UserDao;
import br.eti.avds.blog.model.Autor;
import br.eti.avds.blog.model.Pagina;
import br.eti.avds.blog.model.Post;
import br.eti.avds.blog.model.Tag;
import br.eti.avds.blog.model.User;

@Controller
public class PaginaController {
	
	@RequestMapping("/paginas/index")
	public String index(Model model) {
		PaginaDao dao = new PaginaDao();
		List<Pagina> paginas = dao.getAll();
		model.addAttribute("paginas", paginas);
		return "/paginas/index";
	}
	
	
	@RequestMapping("/paginas/add")
	public String add(HttpServletRequest request,Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(request.getMethod().equals("POST")){//está salvando
			Pagina pagina = new Pagina(request.getParameter("titulo"),request.getParameter("conteudo"));
			pagina.setUser_id(Integer.parseInt(request.getParameter("user_id")));			
			PaginaDao dao = new PaginaDao();
			dao.save(pagina);
			return "redirect:/paginas/index";
		}
		List<User> users = new UserDao().getAll();
		model.addAttribute("users", users);
		
		return "/paginas/add";
	}
	
	
	@RequestMapping("/paginas/edit")
	public String edit(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		PaginaDao dao = new PaginaDao();
		Pagina pagina = dao.get(Integer.parseInt(request.getParameter("id")));
		if(request.getMethod().equals("POST")){//está salvando
			pagina.setUser_id(Integer.parseInt(request.getParameter("user_id")));			
			pagina.setConteudo(request.getParameter("conteudo"));
			pagina.setTitulo(request.getParameter("titulo"));
			dao.update(pagina);
			return "redirect:/paginas/index";
		}
		model.addAttribute("pagina", pagina);
		List<User> users = new UserDao().getAll();
		model.addAttribute("users", users);			
		return "/paginas/edit";
	}
	
	
	@RequestMapping("/paginas/delete")
	public String delete(HttpServletRequest request) {
		PaginaDao dao = new PaginaDao();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/paginas/index";
	}	
}
