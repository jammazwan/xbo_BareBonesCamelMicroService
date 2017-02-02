package cdsf;

import org.apache.camel.builder.RouteBuilder;

import dbinit.InitializeProductCategory;
import repo.UsersRepository;


public class Main {

	public static void main(String[] args) throws Exception {
		new Main().go();
	}

	private void go() throws Exception {
//		new DbCodeReference().go();
//		new InitializeCampaignType().go();
//		new InitializeProductCategory().go();
		UsersRepository ur = new UsersRepository();

		
		org.apache.camel.main.Main main = new org.apache.camel.main.Main();
		main.addRouteBuilder(new MyRoutes());
		main.run();
	}

	private class MyRoutes extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("timer://barebones?fixedRate=true&period=100000").log("\n\n\t Control C to exit");
		}
	}
}