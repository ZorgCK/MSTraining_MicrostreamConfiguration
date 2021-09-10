package one.microstream;

import io.micronaut.runtime.Micronaut;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;


public class Application
{
	
	public static void main(String[] args)
	{
		Micronaut.run(Application.class, args);
		
		EmbeddedStorageManager storageManager_1 = DB.storageManager_1;
	}
}
