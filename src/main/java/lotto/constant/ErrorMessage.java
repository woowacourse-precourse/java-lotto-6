package lotto.constant;

import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

public enum ErrorMessage {
    INITIAL_ERROR_TEXT("[ERROR] "),
    BLANK_INPUT("입력값은 공백일 수 없습니다."),
    INPUT_NOT_DIGIT("입력값은 숫자여야 합니다."),
    EXCEEDED_MAXIMUM_NUMBER_FORMAT("최대로 입력할 수 있는 수를 초과합니다."),
    MONEY_LESS_THAN_ZERO("구매금액은 0 이하일 수 없습니다."),
    MONEY_WITH_REMAINDER("구매금액은 1개의 로또 금액으로 나누어 떨어져야합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호들은 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBERS_AMOUNT("로또 번호 개수가 올바르지 않습니다."),
    NOT_IN_RANGE_LOTTO_NUMBER(
            String.format("로또 번호는 %d와 %d 사이 수여야 합니다.", MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())
    ),
    BONUS_NUMBER_DUPLICATED_WINNING_NUMBERS("보너스 번호가 당첨 번호들과 중복되었습니다."),
    OWNER_ALREADY_MATCH_WITH_WINNING_LOTTO("당첨결과를 중복으로 매기려 합니다."),
    NOT_MATCHING_WITH_WINNING_LOTTO("당첨결과를 보지 않았습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return INITIAL_ERROR_TEXT.message + message;
    }
}
