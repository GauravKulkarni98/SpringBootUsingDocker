package com.app.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pojos.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	public ProductController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping
	public @ResponseBody Product getProductDetails() {
		System.out.println("in get product");
		return new Product(12345L, "Bread", 50, LocalDate.parse("2022-05-06"));
	}

//     /123/oil/200/2022-05-12
	// add req handling method , to read path vars
	@GetMapping("/{pid}/{name}/{price}/{date}")
	public @ResponseBody Product addProductDetails(@PathVariable long pid, @PathVariable String name,
			@PathVariable double price,
			@PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate date) {
		System.out.println("in add product"); // NOT a RESTful DEMO : in REST demo , it will be replaced by @PostMapping
												// for creating a new procudt resouurce.
		return new Product(pid,name,price,date);
	}

}
