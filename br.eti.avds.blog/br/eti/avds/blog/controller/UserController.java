package br.eti.avds.blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.AutorDao;
import br.eti.avds.blog.dao.NivelAcessoDAO;
import br.eti.avds.blog.dao.UserDao;
import br.eti.avds.blog.model.Autor;
import br.eti.avds.blog.model.NivelAcesso;
import br.eti.avds.blog.model.User;
@Controller
public class UserController {
	
	@RequestMapping("/user/index")
	public String index(Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<User> users = new UserDao().getAll();
		model.addAttribute("users", users);
		return "/user/index";
	}
	
	
	@RequestMapping("/user/add")
	public String add(HttpServletRequest request,User user, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(request.getMethod().equals("POST")){//está salvando	
			UserDao dao = new UserDao();
			dao.save(user);
			return "redirect:/user/index";
		}
		
		List<NivelAcesso> niveis = new NivelAcessoDAO().getAll();
		model.addAttribute("niveis", niveis);
		
		return "/user/add";
	}
		
	
	@RequestMapping("/user/edit")
	public String edit(HttpServletRequest request, Model model) throws NumberFormatException, NoSuchAlgorithmException, UnsupportedEncodingException {
		UserDao dao = new UserDao();
		User user = dao.get(Integer.parseInt(request.getParameter("id")));
		if(request.getMethod().equals("POST")){//está salvando
			user.setNome(request.getParameter("nome"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setNivel_acesso_id(Integer.parseInt(request.getParameter("nivel_acesso_id")));
			dao.update(user);
			return "redirect:/user/index";
		}
		
		List<NivelAcesso> niveis = new NivelAcessoDAO().getAll();
		model.addAttribute("niveis", niveis);
		model.addAttribute("user",user);
		return "/user/edit";
	}
	
	
	@RequestMapping("/user/delete")
	public String delete(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		UserDao dao = new UserDao();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/user/index";
	}
	
	@RequestMapping("/user/login")
	public String login(User userLogando, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		UserDao dao = new UserDao();
		if(new User().usuarioExiste(userLogando,dao)) {
			User usuarioLogado = dao.getEmail(userLogando.getEmail());
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "/page/home";
		}
		return "/user/login";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}
