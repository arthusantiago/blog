package br.eti.avds.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.AutorDao;
import br.eti.avds.blog.model.Autor;

@Controller
public class AutorController {
	
	@RequestMapping("/autor/index")
	public String index(Model model) {
		List<Autor> autores = new AutorDao().getAll();
		model.addAttribute("autores", autores);
		return "/autor/index";
	}
	
	
	@RequestMapping("/autor/add")
	public String add(HttpServletRequest request,Model model) {
		if(request.getMethod().equals("POST")){//está salvando
			Autor autor = new Autor(request.getParameter("nome"),
					request.getParameter("email"));
			AutorDao dao = new AutorDao();
			dao.save(autor);
			return "redirect:/autor/index";
		}
		return "/autor/add";
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
}
