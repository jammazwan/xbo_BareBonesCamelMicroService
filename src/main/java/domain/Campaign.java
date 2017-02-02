package domain;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Campaign {

	public String campaignType;
	public String name;
	public String category;
	public long timestamp;
	public String curiousHeadline;
	public String curiousPre;
	public String curiousVideo;
	public String curiousPost;
	public String engagedHeadline;
	public String engagedPre;
	public String engagedVideo;
	public String engagedPost;	

	public Campaign() {
		super();
	}

	@Override
	public String toString() {
		return "Campaign [campaignType=" + campaignType + ", name=" + name + ", category=" + category + ", timestamp="
				+ timestamp + ", curiousHeadline=" + curiousHeadline + ", curiousPre=" + curiousPre + ", curiousVideo="
				+ curiousVideo + ", curiousPost=" + curiousPost + ", engagedHeadline=" + engagedHeadline
				+ ", engagedPre=" + engagedPre + ", engagedVideo=" + engagedVideo + ", engagedPost=" + engagedPost
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
