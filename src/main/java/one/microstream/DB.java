package one.microstream;

import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;


public class DB
{
	public static EmbeddedStorageManager	storageManager_1;
	public final static DataRoot			root_1	= new DataRoot();
	public static EmbeddedStorageManager	storageManager_2;
	public final static DataRoot			root_2	= new DataRoot();
	public static EmbeddedStorageManager	storageManager_3;
	public final static DataRoot			root_3	= new DataRoot();
	public static EmbeddedStorageManager	storageManager_4;
	public final static DataRoot			root_4	= new DataRoot();
	
	public static void initializeShortStorage()
	{
		
	}
	
	public static void initializeXMLStorage()
	{

	}
	
	public static void initializeBuilderStorage()
	{
		// @formatter:off
		
		// @formatter:on 
	}
	
	public static void initializeFoundationStorage()
	{
		// @formatter:off
				
		// @formatter:on 
	}
	
	static
	{
		initializeShortStorage();
		initializeXMLStorage();
		initializeBuilderStorage();
		initializeFoundationStorage();
	}
}
