package br.eti.avds.blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.AutorDao;
import br.eti.avds.blog.dao.UserDao;
import br.eti.avds.blog.model.Autor;
import br.eti.avds.blog.model.User;

public class UserController {
	
	@RequestMapping("/user/index")
	public String index(Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<User> users = new UserDao().getAll();
		model.addAttribute("users", users);
		return "/user/index";
	}
	
	
	@RequestMapping("/user/add")
	public String add(HttpServletRequest request,Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(request.getMethod().equals("POST")){//está salvando
			int id = Integer.parseInt(request.getParameter("id"));
			int nivelAcesso = Integer.parseInt(request.getParameter("nivelAcesso"));
			User user = new User(
					id,
					request.getParameter("nome"),
					request.getParameter("email"),
					request.getParameter("password"),
					nivelAcesso);
			UserDao dao = new UserDao();
			dao.save(user);
			return "redirect:/user/index";
		}
		return "/user/add";
	}
	
	
	@RequestMapping("/autor/edit")
	public String edit(HttpServletRequest request, Model model) {
		AutorDao dao = new AutorDao();
		Autor autor = dao.get(Integer.parseInt(request.getParameter("id")));
		if(request.getMethod().equals("POST")){//está salvando
			autor.setNome(request.getParameter("nome"));
			autor.setEmail(request.getParameter("email"));
			dao.update(autor);
			return "redirect:/autor/index";
		}		
		model.addAttribute("autor",autor);
		return "/autor/edit";
	}
	
	
	@RequestMapping("/autor/delete")
	public String delete(HttpServletRequest request) {
		AutorDao dao = new AutorDao();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/autor/index";
	}
	
//	@RequestMapping("/user/login")
//	public boolean login(HttpServletRequest request) {
//		return 
//	}
}
