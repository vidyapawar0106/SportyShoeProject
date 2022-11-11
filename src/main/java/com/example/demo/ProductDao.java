package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDao {
	@Autowired
	ProductRepo repo;
	public Product insert(Product p)
	{
		return repo.save(p);
		
	}
	public List<Product> getall()
	{
		
		List<Product> list=repo.findAll();
		return list;
		
	}
	public Product editProduct(Product p)
	{
		System.out.println("inside edit");
		Product pp=repo.findById(p.getId()).orElse(null);
		if(p.getPname()!=null)
		{
		pp.setPname(p.getPname());
		}
		else
		{
			pp.setPname(pp.getPname());
		}
		if(p.getCompany()!=null)
		{
		pp.setCompany(p.getCompany());
		}
		else
		{
			pp.setCompany(pp.getCompany());
		}
		if(p.getPsize()!=null)
		{
        pp.setPsize(p.getPsize());
		}
		else
		{
			pp.setPsize(pp.getPsize());
		}
		if(p.getCatagory()!=null)
		{
		pp.setCatagory(p.getCatagory());
		}
		else
		{
			pp.setCatagory(pp.getCatagory());
		}
		if(p.getPrice()!=0)
		{
			pp.setPrice(p.getPrice());
		}
		else
		{
			pp.setPrice(pp.getPrice());
		}
        
       return repo.save(pp);
		
		
		
	}
	public void deleteProduct(int id)
	{
		repo.deleteById(id);
	}
	
    public Product findbyid(int id)
    {
    	return repo.findById(id).orElse(null);
    }
    }


