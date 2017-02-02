package repo;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;

import domain.Campaign;
import domain.ProductCategory;
import util.Db;

public class CampaignRepository {
	DatabaseReference campaignRef;
	DatabaseReference campaignTypeFaqRef = Db.coRef("campaignTypeFaq");
	String path;
	Map<String, Campaign> campaignMap = new HashMap<String, Campaign>();

	public CampaignRepository(String path) {
		campaignRef = Db.coRef(path);
		this.path = path;
		init();
	}

	private void init() {
		campaignRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Campaign campaign = dataSnapshot.getValue(Campaign.class);
                campaignMap.put(path+"/"+dataSnapshot.getKey(), campaign);
//                System.err.println(campaign);
			}

			@Override
			public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                Campaign campaign = dataSnapshot.getValue(Campaign.class);
                campaignMap.put(path+"/"+dataSnapshot.getKey(), campaign);
			}

			@Override
			public void onChildRemoved(DataSnapshot dataSnapshot) {
				campaignMap.remove(path+"/"+dataSnapshot.getKey());
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
}