package jammazwan.xbo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class MyMain {

	public static void main(String[] args) throws Exception {
		new MyMain().go();
	}

	private void go() throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new MyRoutes());
		main.run();
	}

	private class MyRoutes extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("timer://barebones?fixedRate=true&period=1000").log("\n\n\t Control C to exit");
		}
	}
}