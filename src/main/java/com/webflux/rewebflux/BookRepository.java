package com.webflux.rewebflux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer>{

	Mono<Book> findByBookid(int bookid);

	Flux<Book> findByBkname(String bkname);

}
