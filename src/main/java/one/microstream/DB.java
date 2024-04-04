package one.microstream;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import org.eclipse.store.afs.nio.types.NioFileSystem;
import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import org.eclipse.store.storage.embedded.types.EmbeddedStorage;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageFoundation;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.eclipse.store.storage.types.Storage;
import org.eclipse.store.storage.types.StorageBackupSetup;
import org.eclipse.store.storage.types.StorageChannelCountProvider;
import org.eclipse.store.storage.types.StorageConfiguration;

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
