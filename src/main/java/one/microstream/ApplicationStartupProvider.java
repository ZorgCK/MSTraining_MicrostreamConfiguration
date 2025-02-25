package one.microstream;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ApplicationStartupProvider implements ApplicationEventListener<ServerStartupEvent>
{
	@Inject
	private DB db;
	
	@Override
	public void onApplicationEvent(ServerStartupEvent event)
	{
		System.out.println("Startup");
		
		db.initializeBuilderStorage();
		
	}
	
}
