package lotto.utils;

public enum ErrorMessage {
    EMPTY("[ERROR] 입력값이 없습니다."),
    NOT_DIGIT_MONEY("[ERROR] 투입 금액은 숫자만 입력해주세요."),
    DELIMITER("[ERROR] ','로 구분해주시길 바랍니다."),
    NOT_DIGIT_WINNING_NUM("[ERROR] 당첨 번호는 숫자여야 합니다."),
    NOT_DIGIT_BONUS_NUM("[ERROR] 보너스 번호는 숫자여야 합니다."),
    LESS_THAN_THOUSAND("[ERROR] 구입금액은 1000원 부터입니다."),
    DIVIDED_DISABLE("[ERROR] 구입금액은 1000원 단위 입니다."),
    NOT_SIX_NUMBER("[ERROR] 6개의 번호가 필요합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 번호가 있습니다."),
    RANGE("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다."),
    WINNING_NUM_CONTAIN_BONUS_NUM("[ERROR] 당첨 번호 중 보너스 번호가 존재합니다.");



    public final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
