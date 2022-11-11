package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductController {
	@Autowired	
	ProductDao dao;
	@Autowired
	UserRepository repo;
	Logger log=Logger.getAnonymousLogger();
	@RequestMapping("/")
	public ModelAndView loadFrontPage3(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("signIn.jsp");
		return mv;
	}
	
	
	@RequestMapping("/user")
	public ModelAndView loadFrontPage(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("signIn.jsp");
		return mv;
	}
	@RequestMapping("/admin")
	public ModelAndView loadFrontPage1(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		if((repo.findByUsername(username)!=null)&&(repo.findByPassword(password)!=null)) {
			log.info("inside the null condition");
			log.info(repo.findByUsername(username)+ "   "+repo.findByPassword(password));
		if(repo.findByUsername(username).equals(repo.findByPassword(password))) {
			log.info("login is success");
			mv.setViewName("customerhome.jsp");
			mv.addObject("userid",username);
			log.info("control passed to customerhome.jsp");
		}
		}
		else {
			mv.setViewName("fail.jsp");
			log.info("control passed to fail.jsp");
		}
		return mv;

		
		
	}
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response)
	{
		
		ModelAndView mv=new ModelAndView();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		repo.save(user);
	
		mv.setViewName("signIn.jsp");
		return mv;
	}
	@RequestMapping("/insert")
	public ModelAndView addProduct(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		int id=Integer.parseInt(request.getParameter("id"));
		String pname=request.getParameter("name");
		String company=request.getParameter("company");
		String psize=request.getParameter("size");
		String pcategory=request.getParameter("category");
		int price=Integer.parseInt(request.getParameter("price"));
		Product p=new Product();
		p.setId(id);
		p.setPname(pname);
		p.setCompany(company);
		p.setPsize(psize);
		p.setCatagory(pcategory);
		p.setPrice(price);
		Product pp=dao.insert(p);
		List<Product> list=dao.getall();
		if(pp!=null)
		{
			mv.setViewName("displayProduct.jsp");
			mv.addObject("list", list);
		}
		else
		{
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
		
		@RequestMapping("/edit")
		public ModelAndView editProduct(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			int id=Integer.parseInt(request.getParameter("id"));
			String pname=request.getParameter("name");
			String company=request.getParameter("company");
			String psize=request.getParameter("size");
			String pcategory=request.getParameter("category");
			int price=Integer.parseInt(request.getParameter("price"));
			Product p=new Product();
			p.setId(id);
			if(pname!=null)
			{
			p.setPname(pname);
			}
			else
			{
				p.setPname(null);
			}
			if(company!=null)
			{
			p.setCompany(company);
			}
			else
			{
				p.setCompany(null);
			}
			if(psize!=null)
			{
			p.setPsize(psize);
			}
			else
			{
				p.setPsize(null);
			}
			if(pcategory!=null)
			{
			p.setCatagory(pcategory);
			}
			else
			{
				p.setCatagory(null);
			}
			if(price!=0)
			{
			p.setPrice(price);
			}
			else
			{
				p.setPrice(0);
			}
			Product pp=dao.editProduct(p);
			mv.setViewName("home.jsp");
			return mv;
			
		}
		@RequestMapping("/delete")
		public ModelAndView delete(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			//int id=Integer.parseInt(request.getParameter("id"));
			HttpSession s=request.getSession();
			int id=(int) s.getAttribute("id");
			dao.deleteProduct(id);
			mv.setViewName("home.jsp");
			return mv;
			
			
			
		
		}
		@RequestMapping("/display")
		public ModelAndView display(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			List<Product> list=dao.getall();
			mv.setViewName("display.jsp");
			mv.addObject("list", list);
			return mv;
			
			
		}
		@RequestMapping("/display1")
		public ModelAndView userdisplay(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			List<Product> list=dao.getall();
			mv.setViewName("userdisplay.jsp");
			mv.addObject("list", list);
			return mv;
			
		}
		@RequestMapping("/buy")
		public ModelAndView buyproduct(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			int id=Integer.parseInt(request.getParameter("id"));
			Product p=dao.findbyid(id);
			mv.setViewName("buy.jsp");
			mv.addObject("p", p);
			dao.deleteProduct(id);
			return mv;
		}

		@RequestMapping("/viewuser")
		public ModelAndView viewuser(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv=new ModelAndView();
			List<User> list=repo.findAll();
			mv.setViewName("viewuser.jsp");
			mv.addObject("list", list);
			return mv;
			
		}
	}
	


