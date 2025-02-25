package one.microstream;

import java.util.List;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;


@Controller("/books")
public class BookController
{
	@Inject
	private DB db;
	
	@Get("/create")
	public HttpResponse<String> createBooks()
	{
		Book book = new Book("9783732542215", "Origin");
		Book book2 = new Book("9783732542215", "Diabolus");
		Book book3 = new Book("978-3-7341-0742-9", "Die Suche");
		Book book4 = new Book("978-3-7341-0522-7", "Die Erscheinung");
		
		db.root_1.getBooks().addAll(CollectionUtils.setOf(book, book2, book3, book4));
		db.storageManager_1.store(db.root_1.getBooks());
		System.out.println("Books for root_1 successfully created");
		
		db.root_2.getBooks().addAll(CollectionUtils.setOf(book, book2, book3, book4));
		db.storageManager_2.store(db.root_2.getBooks());
		System.out.println("Books for root_2 successfully created");
		
		db.root_3.getBooks().addAll(CollectionUtils.setOf(book, book2, book3, book4));
		db.storageManager_3.store(db.root_3.getBooks());
		System.out.println("Books for root_3 successfully created");
		
		db.root_4.getBooks().addAll(CollectionUtils.setOf(book, book2, book3, book4));
		db.storageManager_4.store(db.root_4.getBooks());
		System.out.println("Books for root_4 successfully created");
		
		return HttpResponse.ok("Books successfully created!");
	}
	
	@Get
	public List<Book> getBook()
	{
		return db.root_1.getBooks();
	}
}
