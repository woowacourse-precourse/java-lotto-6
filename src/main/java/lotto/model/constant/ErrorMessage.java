package lotto.model.constant;

import static lotto.model.constant.LottoConfig.LOTTO_AMOUNT;
import static lotto.model.constant.LottoConfig.LOTTO_SIZE;

public class ErrorMessage {

    public static final String LOTTO_NUMBER_INVALID_SIZE = "[ERROR] 로또 번호의 개수는 " + LOTTO_SIZE + "개만 가능합니다.";
    public static final String NUMBER_INVALID_RANGE = "[ERROR] 잘못된 숫자 범위는 입력될 수 없습니다.";
    public static final String NUMBER_DUPLICATED = "[ERROR] 중복된 번호는 입력될 수 없습니다.";
    public static final String MONEY_INVALID_MINIMUM_AMOUNT = "[ERROR] 돈은 " + LOTTO_AMOUNT + "원 이상 입력가능합니다.";
    public static final String MONEY_INVALID_AMOUNT_UNIT = "[ERROR] 돈은 " + LOTTO_AMOUNT + "원 단위로 입력가능합니다.";

}
