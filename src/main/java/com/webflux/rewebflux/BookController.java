package com.webflux.rewebflux;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
	
	@Autowired
	BookRepository brepo;
	
	@RequestMapping("/test")
	public String test()
	{
		return "data tested";
	}
	@RequestMapping("/save")
	public String save()
	{
		Book b=new Book();
		b.setBkname("ENG Grammer");
		b.setAuthor("R.K Sinha");
		b.setPrice(2300);
		
		brepo.save(b).subscribe();
		return"data saved";
	}
	@RequestMapping("/saveall")
	public String all()
	{
		Book b1=new Book();
		b1.setBkname("Arthashastra");
		b1.setAuthor("Kautilya");
		b1.setPrice(5000);
		
		Book b2=new Book();
		b2.setBkname("Anandmath");
		b2.setAuthor("B.C.Chatterjee");
		b2.setPrice(4500);
		
		Book b3=new Book();
		b3.setBkname("Chandalika");
		b3.setAuthor("Rabindranath Tagore");
		b3.setPrice(6000);
		
		Book b4=new Book();
		b4.setBkname("Chitra");
		b4.setAuthor("Rabindranath Tagore");
		b4.setPrice(3500);
		
		Book b5=new Book();
		b5.setBkname("Dharmashastra");
		b5.setAuthor("Manu");
		b5.setPrice(2500);
		
		Book b6=new Book();
		b6.setBkname("Eternal India");
		b6.setAuthor("Indira Gandhi");
		b6.setPrice(3400);
		
		Book b7=new Book();
		b7.setBkname("Gitanjali");
		b7.setAuthor("Rabindranath Tagore");
		b7.setPrice(3700);
		
		Book b8=new Book();
		b8.setBkname("Hind Swaraj");
		b8.setAuthor("M K Gandhi");
		b8.setPrice(4700);
		
		List<Book>data=Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8);
		brepo.saveAll(data).subscribe();
		return"all data saved";
		
	}
	
	@RequestMapping("/findall")
	Flux<Book> findall()
	{
		return brepo.findAll();
	}
	
	@RequestMapping(value="/new/{bookid}")
	Mono<Book> byid(@PathVariable int bookid)
	{
		return brepo.findByBookid(bookid);
	}
	@RequestMapping(value="/find/{bkname}")
	Flux<Book> byname(@PathVariable String bkname)
	{
		return brepo.findByBkname(bkname);
		
	}

}
