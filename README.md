# Admin Functionality Code Repository

This codebase is perhaps different than other back end servers I am familiar with, because of what it is NOT designed to do.

Most back ends are designed to serve at least these two functionalit sets

 1. Serve up something akin to Repository Pattern APIs for the UI to consume back end data
 2. Serve up an admin functionality API, for functions done on the back end only.
 
This code does not do number 1 above, only number 2!

### General principles followed:

 * Repository Pattern is still the guiding [...] for all data access
 * Repository Pattern is NOT followed as a kind of default API with all CRUD APIs furnished by default.
 
What you end up with is a rule that says something like this. If you do something, you follow the general Repository Pattern layout.

 * basic workflow management in the root *cdfs package*
 * domain or model beans - basic boilerplate beans only - in the *domain package*
 * *XyzRepository class* for all normal and abnormal CRUD operations on any Xyz domain/model
 * *util package* for all the normal back end CRUD workflow support
 * Spring bean support for the normal singleton stuff such as repository classes.
 * see next section on other complications
 
### Other complications and/or new technology

There are two other odd features to this codebase, compared to previous work I have done

 1. Data as callback rather than snapshot as default
 2. Low risk focus and destroy functions to keep memory footprint low.
 
##### CallBack, not SnapShot as default

The Firebase API defaults to callbacks for the data. This is kind of weird for me.

I'm still processing what this means to this codebase.

##### Focus and Destroy

There is some functionality in this codebase which is designed to avoid the memory footprint that the Firebase callback API assumes.

In this case, some of the API is designed to work with both. It gets a little weird.

 * Collect a snapshot of keys for changed data only
 * Iterate that data for a one time admin function
 * Destroy the clone used for the admin function
 * Key/Name Admin Upsert
 
Weird, sorta.

#### Key/Name Admin Upsert

There is another dominant use case for this admin app, and that is 

 * The management of seed data that I'm too lazy to write a UI to maintain

The easy workaround is the upsert and toggling between key and name as search key for the record.

This is an imperfect system that requires a minimum amount of human intervention and tolerance for duplicate data. 
But it's far and away the easiest way to maintain small default data sets with no UI other than the Firebase console.

 * add data by standard add(fields) method
 * update data by update(name, fields) and/or (key, fields)
 * Repository API includes call that fetches update paste-in code such as "upsert("My Name Here", "field2 data here", etc) for already existing records. 
 * delete data through the firebase console, UI, or admin API

### old notes

this started out monitoring the git to see when stuff was committed,

 *    and then did a pull to build and deploy what was committed.
 *  total waste of time, got a ton of it done, but then it wouldn't run polymer

so I realized all that could be put inside the commit.sh script in clouddancer

#### --------

all that is left for this to do is monitor the firebase entries
 * for campaign updates
 **     then, when there is one
 ***           this would do two things
 ****               run camel velocity to create the code for the new campaigns
 ****               run a simple scp script to deploy each campaign as written
  
 

 