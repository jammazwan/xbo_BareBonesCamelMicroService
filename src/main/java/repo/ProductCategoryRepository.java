package repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import domain.ProductCategory;
import util.Db;

public class ProductCategoryRepository {
	DatabaseReference productCategoryRef = Db.coRef("productCategory");
	Map<String, ProductCategory> map = new HashMap<String, ProductCategory>();

	public ProductCategoryRepository() {
		super();
		init();
	}

	private void init() {
		productCategoryRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//				System.err.println("PRODUCT "+ dataSnapshot.getKey());
				ProductCategory productCategory = dataSnapshot.getValue(ProductCategory.class);
				System.err.println(productCategory.toString());
//				map.put(dataSnapshot.getKey(), productCategory);
			}

			@Override
			public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
//				ProductCategory productCategory = dataSnapshot.getValue(ProductCategory.class);
//				map.put(dataSnapshot.getKey(), productCategory);
			}

			@Override
			public void onChildRemoved(DataSnapshot dataSnapshot) {
				map.remove(dataSnapshot.getKey());
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

	public void add(String name) {
		DatabaseReference newCampaignRef = productCategoryRef.push();
		newCampaignRef.setValue(new ProductCategory(name));
	}

	public List<ProductCategory> getList() {
		return (List<ProductCategory>) map.values();
	}

	public Map<String, ProductCategory> getMap() {
		return map;
	}

	public void update(String key, ProductCategory productCategory) {
		productCategoryRef.child(key).setPriority(productCategory);
	}

	public void delete(String key) {
		productCategoryRef.child(key).removeValue();
	}

}
