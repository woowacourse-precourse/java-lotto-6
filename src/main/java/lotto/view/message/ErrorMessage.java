package lotto.view.message;

public enum ErrorMessage {
    NOT_DIGIT_MONEY("투입 금액은 숫자만 입력해주세요."),
    NOT_DIGIT_WINNING_NUM("당첨 번호는 숫자여야 합니다."),
    NOT_DIGIT_BONUS_NUM("보너스 번호는 숫자여야 합니다."),
    LESS_THAN_THOUSAND("구입금액은 1000원 부터입니다."),
    DIVIDED_DISABLE("구입금액은 1000원 단위 입니다."),
    NOT_SIX_NUMBER("6개의 번호가 필요합니다."),
    DUPLICATED_NUMBER("중복된 번호가 있습니다."),
    RANGE("번호는 1부터 45사이의 숫자여야 합니다."),
    WINNING_NUM_CONTAIN_BONUS_NUM("당첨 번호 중 보너스 번호가 존재합니다.");

    public final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = "[ERROR] " + errorMessage;
    }
}
