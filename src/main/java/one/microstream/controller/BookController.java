package one.microstream.controller;

import java.util.List;
import java.util.stream.IntStream;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.DB;
import one.microstream.domain.Book;
import one.microstream.utils.MockupUtils;


@Controller("/books")
public class BookController
{
	@Get("/create")
	public HttpResponse<?> createBooks()
	{
		IntStream.rangeClosed(1, 10).forEach(i ->
		{
			List<Book> allCreatedBooks = MockupUtils.loadMockupData();
			allCreatedBooks.forEach(b ->
			{
				DB.root.getBooks().add(b);
				DB.storageManager.store(DB.root.getBooks());
			});
			
			System.out.println("Durchlauf " + i);
		});
		
		return HttpResponse.ok("Books successfully created!");
	}
	
	@Get
	public List<Book> getBook()
	{
		return DB.root.getBooks();
	}
}
