package lotto.constant;

import static lotto.constant.CommonUnits.MAX_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.MIN_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.MONEY_UNIT;

public class ExceptionMessages {
    public static final String WRONG_INPUT_FORMAT = "[ERROR] 올바른 숫자를 입력해주세요.";

    public static final String WRONG_NUMBER_BOUND = "[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER +
        "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String WRONG_NUMBER_COUNT = "[ERROR] 올바른 갯수의 숫자를 입력해주세요.";
    public static final String WRONG_MONEY_INPUT = "[ERROR] "+ MONEY_UNIT + "원 단위로 입력해주세요.";


}
