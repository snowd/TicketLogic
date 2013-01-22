package com.snowd.ticketlogic;

import java.util.ArrayList;

import android.text.Html;
import android.text.TextUtils;
import android.util.SparseIntArray;

public class LeftTicketState {
	
	private String mStationGetOn;
	private String mStationGetOff;
	private boolean mTrainBeginStation;
	private boolean mTrainEndStation;
	private String mTimeGetOn;
	private String mTimeGetOff;
	private String mTripTimeLast;
	private String mTrainNoShow;
	
	private boolean mBookable = false;
	
	private String pTrainNo4;
	private String pFromStationCode;
	private String pToStationCode;
	private String pFromStationNo;
	private String pToStationNo;
	private String pYpInfoDetail;
	private String pMmStr;
	private String pLocationCode;
	
	private SparseIntArray mSeatNumMap;
	
	public static enum Seat {
		GSEAT_VIP, GSEAT_SPECIAL, GSEAT_FIRST, GSEAT_SECOND, 
		SLEEPER_VIP, SLEEPER_SOFT, SLEEPER_HARD, 
		SEAT_SOFT, SEAT_HARD, NONE_SEAT, OTHERS, length
	}
	
	
	public int getLeftNumBySeat(Seat seat) {
		if (mSeatNumMap == null) {
			return SEAT_NOT_EXIST;
		}
		return mSeatNumMap.get(seat.ordinal(), SEAT_NOT_EXIST);
	}
	
	public static ArrayList<LeftTicketState> createListFromHtml(String html) throws Exception {
		if (TextUtils.isEmpty(html)) {
			return null;
		}
		String[] slist = html.split("\\n");
		if (slist == null) {
			throw new Exception("parse ticket info exception");
		}
		ArrayList<LeftTicketState> list = new ArrayList<LeftTicketState>(slist.length);
		for (int i = 0; i < slist.length; i++) {
			list.add(LeftTicketState.createFromHtml(slist[i]));
		}
		return list;
	}
	
	public static LeftTicketState createFromHtml(String html) throws Exception {
		html = html.replaceAll("&nbsp;", "");
		String trainSummary = Html.fromHtml(html).toString();
		
		String[] detail = html.split(",");
		String[] info = trainSummary.split(",");
		if (info == null || info.length < 16) {
			return null;
		}
		LeftTicketState state = new LeftTicketState();
		state.mTrainNoShow = info[1];
		state.mTripTimeLast = info[4];
		state.parseLeftSeatNum(info);
		
		String[] stationInfo = detail[2].split("<br>");
		state.mTrainBeginStation = stationInfo[0].startsWith("<img ");
		state.mTimeGetOn = stationInfo[1];
		if (state.mTrainBeginStation) {
			int offset = stationInfo[0].indexOf(">");
			state.mStationGetOn = stationInfo[0].substring(offset + 1); 
		} else {
			state.mStationGetOn = stationInfo[0];
		}
		
		stationInfo = detail[3].split("<br>");
		state.mTrainEndStation = stationInfo[0].startsWith("<img ");
		state.mTimeGetOff = stationInfo[1];
		if (state.mTrainEndStation) {
			int offset = stationInfo[0].indexOf(">");
			state.mStationGetOff = stationInfo[0].substring(offset + 1); 
		} else {
			state.mStationGetOff = stationInfo[0];
		}
		
		if (state.mBookable) {
			state.parseOrderParams(detail[16]);
		}
		return state;
	}
	
	private static final int OFFSET_LEFT_NUM = 5;
	private static final int SEAT_ENOUGHT = -1;
	private static final int SEAT_NOT_EXIST = -2;
	private static final int SEAT_NOT_ON_SEAL = -3;
	
	private void parseLeftSeatNum(String[] info) {
		if (info == null || info.length < OFFSET_LEFT_NUM
				+ Seat.length.ordinal()) {
			return;
		}
		mSeatNumMap = new SparseIntArray();
		for (int i = OFFSET_LEFT_NUM; i < OFFSET_LEFT_NUM
				+ Seat.length.ordinal(); i++) {
			String dataStr = info[i];
			if ("--".equals(dataStr)) {
				continue;
			}
			if ("*".equals(dataStr)) {
				mSeatNumMap.put(i - OFFSET_LEFT_NUM, SEAT_NOT_ON_SEAL);
				continue;
			}
			if ("有".equals(dataStr)) {
				mSeatNumMap.put(i - OFFSET_LEFT_NUM, SEAT_ENOUGHT);
				mBookable = true;
				continue;
			}
			if ("无".equals(dataStr)) {
				mSeatNumMap.put(i - OFFSET_LEFT_NUM, 0);
				continue;
			}
			try {
				int num = Integer.parseInt(dataStr);
				mBookable = num > 0;
				mSeatNumMap.put(i - OFFSET_LEFT_NUM, num);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void parseOrderParams(String actionStr) throws Exception {
		String[] values = actionStr.split("'");
		if (values == null || values.length < 8) {
			throw new Exception("parse ticket info exception");
		}
		values = values[7].split("#");
		if (values == null || values.length < 14) {
			throw new Exception("parse ticket info exception");
		}
		
		pTrainNo4 = values[3];
		pFromStationCode = values[4];
		pToStationCode = values[5];
		pFromStationNo = values[9];
		pToStationNo = values[10];
		pYpInfoDetail = values[11];
		pMmStr = values[12];
		pLocationCode = values[13];
	}
	
	@Override
	public String toString() {
		return mTrainNoShow + " > " + (mBookable ? mSeatNumMap : "no ticket");
	}
	
	public String getmStationGetOn() {
		return mStationGetOn;
	}
	public String getmStationGetOff() {
		return mStationGetOff;
	}
	public boolean ismTrainBeginStation() {
		return mTrainBeginStation;
	}
	public boolean ismTrainEndStation() {
		return mTrainEndStation;
	}
	public String getmTimeGetOn() {
		return mTimeGetOn;
	}
	public String getmTimeGetOff() {
		return mTimeGetOff;
	}
	public String getmTripTimeLast() {
		return mTripTimeLast;
	}
	public String getmTrainNoShow() {
		return mTrainNoShow;
	}
	public String getpTrainNo4() {
		return pTrainNo4;
	}
	public String getpFromStationCode() {
		return pFromStationCode;
	}
	public String getpToStationCode() {
		return pToStationCode;
	}
	public String getpFromStationNo() {
		return pFromStationNo;
	}
	public String getpToStationNo() {
		return pToStationNo;
	}
	public String getpYpInfoDetail() {
		return pYpInfoDetail;
	}
	public String getpMmStr() {
		return pMmStr;
	}
	public String getpLocationCode() {
		return pLocationCode;
	}
	public SparseIntArray getmSeatNumMap() {
		return mSeatNumMap;
	}
	
}