package repo;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import util.Db;

public class UserRepository {
	DatabaseReference ref;
	Map<String, CampaignRepository> campaignRepositoryMap = new HashMap<String, CampaignRepository>();
	Map<String, EmailContentRepository> emailContentRepositoryMap = new HashMap<String, EmailContentRepository>();
	Map<String, EmailLookupRepository> emailLookupRepositoryMap = new HashMap<String, EmailLookupRepository>();
	Map<String, CampaignNameRepository> campaignNameRepositoryMap = new HashMap<String, CampaignNameRepository>();
	String userKey;

	public UserRepository(String key) {
		this.userKey = key;
		ref = Db.coRef("users/" + key);
		init();
	}

	private void init() {
		ref.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
				dispatch(dataSnapshot.getKey());
			}


			@Override
			public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
				dispatch(dataSnapshot.getKey());
			}

			@Override
			public void onChildRemoved(DataSnapshot dataSnapshot) {
			}

			@Override
			public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {

			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				throw new RuntimeException(databaseError.getMessage());
			}
		});
	}

	private void dispatch(String key) {
		String path = "users/"+userKey + "/" + key;
	     switch (key) {
	         case "campaign":
	             campaignRepositoryMap.put(path, new CampaignRepository(path));
					
	             break;
	         case "campaignName":
	        	 campaignNameRepositoryMap.put(path, new CampaignNameRepository(path));
	        	 break;
	         case "emailLookup":
	        	 emailLookupRepositoryMap.put(path, new EmailLookupRepository(path));
	        	 break;
	         case "emailContent":
	        	 emailContentRepositoryMap.put(path, new EmailContentRepository(path));
	        	 break;
	         default:
	             System.err.println("DIDN'T LOOK FOR "+key + " PLEASE FIX ME");
	     }		
	}
}
