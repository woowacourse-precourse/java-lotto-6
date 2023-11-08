package lotto.Util;

import lotto.Lotto;

public class ErrorMessage {
    public static final String ZERO_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.";
    public static final String THOUSAND_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위로 입력돼야 합니다.";
    public static final String NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호 갯수가" + Lotto.LOTTO_SIZE + "자가 입력돼야 합니다.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE= "[ERROR] 로또 번호는 "+ Lotto.MIN_LOTTO_RANGE + "부터 " + Lotto.MAX_LOTTO_RANGE+" 사이의 숫자여야 합니다.";
    public static final String NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복이 아닌 숫자로 입력돼야 합니다.";
    public static final String PRIZE_SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개이어야 합니다.";
    public static final String INT_ERROR_MESSAGE = "[ERROR] 입력 값은 정수 형이어야 합니다.";

}
