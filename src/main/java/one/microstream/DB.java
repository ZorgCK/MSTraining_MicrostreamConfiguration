package one.microstream;

import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;

import io.micronaut.context.annotation.Value;


public class DB
{
	@Value("${storage.path}") private String		path;
	@Value("${storage.backuppath}") private String	path_backup;
	@Value("${storage.channels}") private Integer	channel;
	
	public EmbeddedStorageManager					storageManager_1;
	public final DataRoot							root_1	= new DataRoot();
	public EmbeddedStorageManager					storageManager_2;
	public final DataRoot							root_2	= new DataRoot();
	public EmbeddedStorageManager					storageManager_3;
	public final DataRoot							root_3	= new DataRoot();
	public EmbeddedStorageManager					storageManager_4;
	public final DataRoot							root_4	= new DataRoot();
	
	public void initializeShortStorage()
	{
		
	}
	
	public void initializeXMLStorage()
	{
		
	}
	
	public void initializeBuilderStorage()
	{
		// @formatter:off
		
		// @formatter:on 
	}
	
	public void initializeFoundationStorage()
	{
		// @formatter:off
				
		// @formatter:on 
	}
}
