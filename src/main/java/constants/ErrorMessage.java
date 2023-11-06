package constants;

public enum ErrorMessage {

    INVALID_MONEY_ERROR("로또 구입 금액은 로또 1장의 금액(%d 원)으로 나누어떨어져야 합니다."),
    ANSWER_LOTTO_LENGTH_ERROR("당첨번호의 길이가 %d이(가) 아닙니다"),
    ANSWER_LOTTO_HAS_DUPLICATE_NUMBER_ERROR("당첨번호에 중복된 숫자가 포함되어 있습니다."),
    ANSWER_LOTTO_NOT_IN_RANGE_ERROR("당첨번호에 %d~%d 범위 외의 숫자가 포함되어 있습니다."),
    BONUS_NUMBER_RANGE_ERROR("보너스 숫자는 %d~%d 범위 외의 숫자가 될 수 없습니다."),
    BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR("당첨번호에 포함된 숫자는 보너스 번호가 될 수 없습니다."),
    BLANK_INPUT_ERROR("공백이 입력되었습니다."),
    INVALID_NUMBER_FORMAT_ERROR("숫자 형식으로 입력해주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
