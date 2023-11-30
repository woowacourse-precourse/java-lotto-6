package lotto.util;

import lotto.util.Constant;

public class ExceptionMessage {
	public static final String LOTTO_NUM_OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 번호는 " + Constant.LOTTO_MIN_NUMBER + "부터 " + Constant.LOTTO_MIN_NUMBER + " 사이의 숫자여야 합니다.";
	public static final String LOTTO_NUM_DUPLICATED_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
	public static final String LOTTO_NUM_SIZE_MESSAGE = "[ERROR] 로또 번호는 " + Constant.LOTTO_SIZE + "개여야 합니다.";
	public static final String LOTTO_NUM_NOT_INTEGER_MESSAGE = "[ERROR] 로또 번호는 정수여야 합니다.";
	public static final String BONUS_NUM_DUPLICATED_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";

	public static final String PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE = "[ERROR] 로또 구입 금액은 정수여야 합니다.";
	public static final String PURCHASE_AMOUNT_OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 구입 금액은 최소 " + Constant.LOTTO_PRICE + " 이어야 합니다.";
	public static final String PURCHASE_AMOUNT_REMAINDER_IS_NOT_ZERO_MESSAGE = "[ERROR] 로또 구입 금액은 " + Constant.LOTTO_PRICE + "의 배수여야 합니다.";
}
