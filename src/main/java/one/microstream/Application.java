package one.microstream;

import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;

import io.micronaut.runtime.Micronaut;

public class Application
{
	
	public static void main(String[] args)
	{
		Micronaut.run(Application.class, args);
		
		EmbeddedStorageManager storageManager_1 = DB.storageManager_1;
	}
}
