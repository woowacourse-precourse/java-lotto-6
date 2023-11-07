package lotto.exception;

import static lotto.constants.LottoRule.LOTTO_COST;
import static lotto.constants.LottoRule.LOTTO_COST_REMAIN_VALUE;
import static lotto.constants.LottoRule.LOTTO_NUMBER_LENGTH;
import static lotto.constants.LottoRule.MAXIMUM_NUMBER;
import static lotto.constants.LottoRule.MINIMUM_NUMBER;

public enum ExceptionMessage {

    NUMBER_FORMAT_EXCEPTION("숫자가 아니거나 너무 큰 수, 또는 너무 작은 수를 입력하였습니다."),
    NULL_EXCEPTION("null 값은 들어올 수 없습니다."),
    NEGATIVE_NUMBER_EXCEPTION("양수 (0 포함)여야 합니다."),
    INVEST_MONEY_VALUE_EXCEPTION("투자 금액은 최소 " + LOTTO_COST.getValue() + "원 이상이어야 합니다."),
    NUMBER_DUPLICATE_EXCEPTION("숫자들은 모두 독립적이어야 합니다."),
    MONEY_REMAIN_EXCEPTION("구입 금액은 " + LOTTO_COST.getValue() + "으로 나눌 때 나머지가 " +
            LOTTO_COST_REMAIN_VALUE.getValue() + "이어야 합니다."),
    GOAL_NUMBER_SIZE_EXCEPTION("올바른 로또 정답 갯수가 아닙니다. 정답 갯수는 " + LOTTO_NUMBER_LENGTH.getValue() + "개여야 합니다."),
    UNVALID_GOAL_NUMBER(
            "로또에서 생성될 수 없는 숫자가 있습니다. 로또 번호는 " + MINIMUM_NUMBER.getValue() + " ~ " +
            MAXIMUM_NUMBER.getValue() + " 사이여야 합니다."
    ),
    BONUS_NUMBER_ALREADY_USE("정답 번호에 없는 숫자여야만 합니다.");

    private static final String DEFAULT_MESSAGE = "[ERROR] ";
    
    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return DEFAULT_MESSAGE + message;
    }
}
