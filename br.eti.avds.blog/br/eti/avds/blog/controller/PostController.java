package br.eti.avds.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.eti.avds.blog.dao.AutorDao;
import br.eti.avds.blog.dao.PostDao;
import br.eti.avds.blog.dao.TagDao;
import br.eti.avds.blog.model.Autor;
import br.eti.avds.blog.model.Post;
import br.eti.avds.blog.model.Tag;

@Controller
public class PostController {
	
	@RequestMapping("/post/index")
	public String index(Model model) {
		PostDao dao = new PostDao();
		List<Post> posts = dao.getAll();
		model.addAttribute("posts", posts);
		return "/post/index";
	}
	
	
	@RequestMapping("/post/add")
	public String add(HttpServletRequest request,Model model) {
		if(request.getMethod().equals("POST")){//está salvando
			Post post = new Post(request.getParameter("titulo"),request.getParameter("texto"));
			post.setAutor_id(Integer.parseInt(request.getParameter("autor_id")));
			post.setTag_id(Integer.parseInt(request.getParameter("tag_id")));
			PostDao dao = new PostDao();
			dao.save(post);
			return "redirect:/post/index";
		}
		List<Autor> autores = new AutorDao().getAll();
		model.addAttribute("autores", autores);
		List<Tag> tags = new TagDao().getAll();
		model.addAttribute("tags", tags);
		return "/post/add";
	}
	
	
	@RequestMapping("/post/edit")
	public String edit(HttpServletRequest request, Model model) {
		PostDao dao = new PostDao();
		Post post = dao.get(Integer.parseInt(request.getParameter("id")));
		if(request.getMethod().equals("POST")){//está salvando
			post.setAutor_id(Integer.parseInt(request.getParameter("autor_id")));
			post.setTag_id(Integer.parseInt(request.getParameter("tag_id")));
			post.setTexto(request.getParameter("texto"));
			post.setTitulo(request.getParameter("titulo"));
			dao.update(post);
			return "redirect:/post/index";
		}
		model.addAttribute("post", post);
		List<Autor> autores = new AutorDao().getAll();
		model.addAttribute("autores", autores);
		List<Tag> tags = new TagDao().getAll();
		model.addAttribute("tags", tags);
		return "/post/edit";
	}
	
	
	@RequestMapping("/post/delete")
	public String delete(HttpServletRequest request) {
		PostDao dao = new PostDao();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(dao.get(id));
		return "redirect:/post/index";
	}	
}
