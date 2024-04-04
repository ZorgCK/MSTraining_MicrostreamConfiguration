package one.microstream;

import java.net.URL;
import java.util.Optional;

import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;

import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.io.scan.ClassPathResourceLoader;


public class DB
{
	public static EmbeddedStorageManager	storageManager_1;
	public final static DataRoot			root_1	= new DataRoot();
	public static EmbeddedStorageManager	storageManager_2;
	public final static DataRoot			root_2	= new DataRoot();
	public static EmbeddedStorageManager	storageManager_3;
	public final static DataRoot			root_3	= new DataRoot();
	
	public static void initializeXMLStorage()
	{
		ClassPathResourceLoader loader = new ResourceResolver().getLoader(ClassPathResourceLoader.class).get();
		Optional<URL> resource = loader.getResource("microstream.xml");
		
		storageManager_1 = EmbeddedStorageConfiguration.load(
			resource.get().getPath()).createEmbeddedStorageFoundation().createEmbeddedStorageManager(root_1).start();
	}
	
	public static void initializeBuilderStorage()
	{
		
	}
	
	public static void initializeFoundationStorage()
	{
		
	}
	
	static
	{
		initializeXMLStorage();
		initializeBuilderStorage();
		initializeFoundationStorage();
	}
}
