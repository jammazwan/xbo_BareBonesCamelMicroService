package fba;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NsLevel {

	public void doSomething(FirebaseDatabase defaultDatabase) throws FileNotFoundException {
		DatabaseReference ref = defaultDatabase.getReference("/");

		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				System.err.println(dataSnapshot);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				// ...
			}
		});
	}
}