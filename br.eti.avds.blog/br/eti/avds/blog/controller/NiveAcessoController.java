package br.eti.avds.blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.eti.avds.blog.dao.NivelAcessoDAO;
import br.eti.avds.blog.model.NivelAcesso;

@Controller
public class NiveAcessoController {
	
	@RequestMapping("/nivel-acesso/index")
	public String index(Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<NivelAcesso> niveis = new NivelAcessoDAO().getAll();
		model.addAttribute("niveis", niveis);
		return "/nivel-acesso/index";
	}	
	
	@RequestMapping("/nivel-acesso/add")
	public String add(HttpServletRequest request,NivelAcesso nivel) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(request.getMethod().equals("POST")){//está salvando
			
			nivel.setId(1);//codigo temporario			
			NivelAcessoDAO dao = new NivelAcessoDAO();
			dao.save(nivel);
			return "redirect:/nivel-acesso/index";
		}
		return "/nivel-acesso/add";
	}
	
	@RequestMapping("/nivel-acesso/edit")
	public String edit(HttpServletRequest request, Model model) throws NumberFormatException, NoSuchAlgorithmException, UnsupportedEncodingException {
		NivelAcessoDAO dao = new NivelAcessoDAO();
		NivelAcesso nivel = dao.get(Integer.parseInt(request.getParameter("id")));
		if(request.getMethod().equals("POST")){//está salvando
			nivel.setNome(request.getParameter("nome"));			
			dao.update(nivel);
			return "redirect:/nivel-acesso/index";
		}		
		model.addAttribute("nivel",nivel);
		return "/nivel-acesso/edit";
	}
	
	
	@RequestMapping("/nivel-acesso/delete")
	public String delete(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		NivelAcessoDAO dao = new NivelAcessoDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/nivel-acesso/index";
	}
	


}
