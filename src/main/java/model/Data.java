package model;

public class Data {

	public static final int UNIT_PRICE=Constants.UNIT_PRICE.getConstants();
	public static final int INIT_CNT=Constants.INIT_CNT.getConstants();
	
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
}
