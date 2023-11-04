package lotto.global;

public enum ErrorMessage {

    INPUT_NUMBER_IS_INVALID("[ERROR] 유효한 숫자를 입력해주세요."),
    INPUT_NUMBER_IS_NOT_DIGIT("[ERROR] 숫자를 입력해 주세요."),
    LOTTO_LENGTH_IS_NOT_SIX("[ERROR] 로또 숫자 리스트의 길이는 6이여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 숫자가 중복 되었습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
