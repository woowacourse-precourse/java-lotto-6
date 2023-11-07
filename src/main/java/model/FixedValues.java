package model;

import creator.ObjectCreator;

public class FixedValues {

	public static final int UNIT_PRICE=Constants.UNIT_PRICE.getConstants();
	public static final int INIT_CNT=Constants.INIT_CNT.getConstants();
	
	public static final double PARSING_TO_DOUBLE_PERCENTAGE=100.0;
	
	public static final int MIN_NUM=Constants.MIN_NUM.getConstants();
	public static final int MAX_NUM=Constants.MAX_NUM.getConstants();
	public static final int CORRECT_CNT=Constants.CORRECT_CNT.getConstants();
	
	public static final int MATCHING_THREE=LottoCorresponding.THREE.getWinnings();
	public static final int MATCHING_FOUR=LottoCorresponding.FOUR.getWinnings();
	public static final int MATCHING_FIVE=LottoCorresponding.FIVE.getWinnings();
	public static final int WITH_BONUS=LottoCorresponding.BONUS.getWinnings();
	public static final int MATCHING_ALL=LottoCorresponding.ALL.getWinnings();
	
	public static final String EMPTY=MoneyError.EMPTY.getErrorMsg();
	public static final String NUM_FORM=MoneyError.NUM_FORM.getErrorMsg();
	public static final String CHANGES=MoneyError.CHANGES.getErrorMsg();
	
	public static final String MORE_OR_LESS=NumberError.MORE_OR_LESS.getErrorMsg();
	public static final String DUPLICATE=NumberError.DUPLICATE.getErrorMsg();
	public static final String NAN=NumberError.NAN.getErrorMsg();
	public static final String BOUNDARY=NumberError.BOUNDARY.getErrorMsg();
	
	public static final String PURCHASE_GUIDE=Announcement.PURCHASE_GUIDE.getAnnouncement();
	public static final String FEEDBACK_PURCHASE=Announcement.FEEDBACK_PURCHASE.getAnnouncement();
	
	public static final String WINNGIN_NUM_GUIDE=Announcement.WINNGIN_NUM_GUIDE.getAnnouncement();
	public static final String BONUS_GUIDE=Announcement.BONUS_GUIDE.getAnnouncement();
	
	public static final String STATISTICS_START=Announcement.STATISTICS_START.getAnnouncement();
	public static final String CORRESPONDING_THREE=Announcement.CORRES_THREE.getAnnouncement();
	public static final String CORRESPONDING_FOUR=Announcement.CORRES_FOUR.getAnnouncement();
	public static final String CORRESPONDING_FIVE=Announcement.CORRES_FIVE.getAnnouncement();
	public static final String CORRESPONDING_BONUS=Announcement.CORRES_BONUS.getAnnouncement();
	public static final String CORRESPONDING_ALL=Announcement.CORRES_ALL.getAnnouncement();
	
	public static final ObjectCreator CREATOR=new ObjectCreator();
}
