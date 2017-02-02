package fba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserCampaign {

	public void doSomething(FirebaseDatabase defaultDatabase) throws FileNotFoundException {
		System.err.println("STARTING UP USER CAMPAIGN CLASS");
		DatabaseReference ref = defaultDatabase.getReference("users");
		Map<String, Object> something = new HashMap<String, Object>();
		DataSnapshot a;
		DatabaseError b;
		ref.addChildEventListener( new ChildEventListener() {
			
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				System.out.println("CHANGE INSIDE " +arg0.getKey());
			}
			
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				System.out.println("ADDING " +arg0.getKey());
			}
			
			public void onCancelled(DatabaseError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
