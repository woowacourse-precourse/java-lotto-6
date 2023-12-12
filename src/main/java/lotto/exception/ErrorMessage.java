package lotto.exception;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR]"),
    INPUT_CONTAIN_NOT_NUMBER(" 입력에 숫자가 아닌 값이 들어왔습니다."),
    LOTTO_DUPLICATED_NUMBER("로또 번호가 중복됩니다"),
    LOTTO_NUMBER_RANGE_OVER("로또 번호의 수는 6개여야만 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
