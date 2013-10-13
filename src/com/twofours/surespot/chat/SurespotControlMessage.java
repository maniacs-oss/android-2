package com.twofours.surespot.chat;

import org.json.JSONException;
import org.json.JSONObject;

import com.twofours.surespot.common.SurespotLog;

public class SurespotControlMessage {
	private static final String TAG = "SurespotControlMessage";
	private String mType;
	private String mAction;
	private String mData;
	private String mMoreData;
	private Integer mId;
	private String mLocalId;
	private String mFrom;

	public String getType() {
		return mType;
	}

	public void setType(String type) {
		mType = type;
	}

	public String getAction() {
		return mAction;
	}

	public void setAction(String action) {
		mAction = action;
	}

	public String getData() {
		return mData;
	}

	public void setData(String data) {
		mData = data;
	}

	public String getMoreData() {
		return mMoreData;
	}

	public void setMoreData(String moreData) {
		mMoreData = moreData;
	}

	public Integer getId() {
		return mId;
	}

	public void setId(Integer id) {
		mId = id;
	}

	public String getLocalId() {
		return mLocalId;
	}

	public void setLocalId(String localId) {
		mLocalId = localId;
	}

	public String getFrom() {
		return mFrom;
	}

	public void setFrom(String from) {
		mFrom = from;
	}

	public static SurespotControlMessage toSurespotControlMessage(JSONObject jsonMessage) throws JSONException {
		SurespotControlMessage controlMessage = new SurespotControlMessage();

		
		controlMessage.setType(jsonMessage.getString("type"));
		controlMessage.setId(jsonMessage.getInt("id"));
		controlMessage.setAction(jsonMessage.getString("action"));
		controlMessage.setData(jsonMessage.getString("data"));
		
		controlMessage.setFrom(jsonMessage.optString("from"));
		controlMessage.setMoreData(jsonMessage.optString("moredata", null));
		controlMessage.setLocalId(jsonMessage.optString("localid", null));
		return controlMessage;
	}

	public JSONObject toJSONObject() {
		JSONObject message = new JSONObject();

		try {
			message.put("from", this.getFrom());
			message.put("type", this.getType());
			message.put("id", this.getId());
			message.put("action", this.getAction());
			message.put("data", this.getData());

			if (this.getMoreData() != null) {
				message.put("moredata", this.getMoreData());
			}

			if (this.getLocalId() != null) {
				message.put("localid", this.getLocalId());
			}

			return message;
		}
		catch (JSONException e) {
			SurespotLog.w(TAG, "toJSONObject", e);
		}
		return null;

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		result = prime * result + ((mLocalId == null) ? 0 : mLocalId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		SurespotControlMessage rhs = (SurespotControlMessage) obj;

		if (this.getId() != null && rhs.getId() != null && this.getId().equals(rhs.getId())) {
			return true;
		}
		else {
			if (this.getLocalId() != null && rhs.getLocalId() != null && this.getLocalId().equals(rhs.getLocalId())) {
				return true;
			}
			else {
				return false;
			}			
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nSurespotControlMessage:\n");
		sb.append("\tid: " + getId() + "\n");		
		sb.append("\tfrom: " + getFrom() + "\n");
		sb.append("\taction: " + getAction() + "\n");
		sb.append("\tlocalId: " + getLocalId() + "\n");		
		sb.append("\tdata: " + getData() + "\n");
		sb.append("\tmoreData: " + getMoreData() + "\n");
		
		return sb.toString();
	}


}
