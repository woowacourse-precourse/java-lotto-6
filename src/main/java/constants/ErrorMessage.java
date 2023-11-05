package constants;

public enum ErrorMessage {
    ANSWER_LOTTO_LENGTH_ERROR("당첨번호의 길이가 %d이(가) 아닙니다"),
    ANSWER_LOTTO_HAS_DUPLICATE_NUMBER_ERROR("당첨번호에 중복된 숫자가 포함되어 있습니다."),
    ANSWER_LOTTO_NOT_IN_RANGE_ERROR("당첨번호에 %d~%d 범위 외의 숫자가 포함되어 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
