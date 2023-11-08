package lotto.enums;

public enum ErrorMessageEnum {
    ERROR_LOTTO_COUNT_MESSAGE("[ERROR] 로또 번호는 6개 숫자여야 합니다."),
    ERROR_LOTTO_NOT_UNIQUE_MESSAGE("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    ERROR_LOTTO_NOT_NUMBER_MESSAGE("[ERROR] 로또 번호는 숫자여야 합니다.");

    private String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
