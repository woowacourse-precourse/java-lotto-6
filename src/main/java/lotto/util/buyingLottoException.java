package lotto.util;

public class buyingLottoException {
	private final static int LOTTO_PRICE = 1000;
	private final static String ERROR="[ERROR] ";
	private final static String LOTTO_NOT_IN_RANGE_OF_ONE_TO_FOURTY_FIVE_ERROR="로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	private final static String lOTTO_PRICE_MUST_BE_THOUSAND_ERROR="구매는 1,000원 단위로 가능합니다.";
	private final static String LOTTO_PRICE_INPUT_INTEGER_ERROR="입력은 숫자만 가능합니다.";

	public static void validateBuyingPrice(String buyingPrice) {
		isNumberCheck(buyingPrice);
		isPriceCheck(buyingPrice);
	}
	public static void isNumberCheck(String buyingPrice) {
		int tempbuyingPrice = Integer.parseInt(buyingPrice);
		if(tempbuyingPrice % LOTTO_PRICE !=0) {
			throw new IllegalArgumentException(ERROR+lOTTO_PRICE_MUST_BE_THOUSAND_ERROR);
		}
	}
	public static void isPriceCheck(String buyingPrice) {
		for(int i=0;i<buyingPrice.length();i++) {
			char tempPrice = buyingPrice.charAt(i);
			if(!('0'<= tempPrice && tempPrice<='9')) {
				throw new NumberFormatException(ERROR+LOTTO_PRICE_INPUT_INTEGER_ERROR);
			}
		}
	}

}
