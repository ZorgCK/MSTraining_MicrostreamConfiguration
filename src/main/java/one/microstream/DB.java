package one.microstream;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.io.scan.ClassPathResourceLoader;
import one.microstream.afs.nio.types.NioFileSystem;
import one.microstream.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageFoundation;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import one.microstream.storage.types.Storage;
import one.microstream.storage.types.StorageBackupSetup;
import one.microstream.storage.types.StorageChannelCountProvider;
import one.microstream.storage.types.StorageConfiguration;


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
		storageManager_1 = EmbeddedStorage.start(
			root_1,
			Paths.get("shortStorage"));
	}
	
	public static void initializeXMLStorage()
	{
		ClassPathResourceLoader loader = new ResourceResolver().getLoader(ClassPathResourceLoader.class).get();
		Optional<URL> resource = loader.getResource("microstream.xml");
		
		storageManager_2 = EmbeddedStorageConfiguration.load(
			resource.get().getPath()).createEmbeddedStorageFoundation().createEmbeddedStorageManager(root_2).start();
	}
	
	
	public static void initializeBuilderStorage()
	{
		// @formatter:off
		
		storageManager_3 = EmbeddedStorageConfiguration.Builder()
			.setStorageDirectory("builderStorage")
			.setBackupDirectory("builderStorage/backup")
			.setChannelCount(4)
			.createEmbeddedStorageFoundation()
			.setRoot(root_3)
			.createEmbeddedStorageManager().start();

		// @formatter:on 
	}
	
	public static void initializeFoundationStorage()
	{
		// @formatter:off
		
		NioFileSystem          fileSystem     = NioFileSystem.New();
		storageManager_4 = EmbeddedStorageFoundation.New()
			.setConfiguration(
				StorageConfiguration.Builder()
					.setStorageFileProvider(
						Storage.FileProviderBuilder(fileSystem)
							.setDirectory(fileSystem.ensureDirectoryPath("foundationStorage"))
							.createFileProvider()
					)
					.setChannelCountProvider(StorageChannelCountProvider.New(4))
					.setBackupSetup(StorageBackupSetup.New(
						fileSystem.ensureDirectoryPath("foundationStorage/backupDir")
					))
					.createConfiguration()
			)
			.setRoot(root_4)
			.createEmbeddedStorageManager().start();
		
		// @formatter:on 
	}
	
	static
	{
		initializeXMLStorage();
		initializeShortStorage();
		initializeBuilderStorage();
		initializeFoundationStorage();
	}
}
