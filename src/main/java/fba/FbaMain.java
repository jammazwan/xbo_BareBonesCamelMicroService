package fba;

import java.io.FileInputStream;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class FbaMain {

	public static void main(String[] args) throws Exception {
		new FbaMain().go();
	}

	public void go() throws Exception {
		FirebaseOptions options = new FirebaseOptions.Builder().setServiceAccount(new FileInputStream(
				// "/Users/petecarapetyan/clouddancer-258e3-firebase-adminsdk-i1z97-45a327177d.json"))
				"/Users/petecarapetyan/work/cdsf/autocdfs/clouddancerco-firebase-adminsdk-a25d8-a3c770995c.json"))
				// .setDatabaseUrl("https://clouddancer-258e3.firebaseio.com").build();
				.setDatabaseUrl("https://clouddancerco.firebaseio.com").build();
		FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
		FirebaseAuth defaultAuth = FirebaseAuth.getInstance(defaultApp);
		final FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance(defaultApp);
		new NsLevel().doSomething(defaultDatabase);
		// new UserCampaign().doSomething(defaultDatabase);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

		}
	}

}
