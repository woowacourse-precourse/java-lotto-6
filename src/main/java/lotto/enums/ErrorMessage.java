package lotto.enums;

public enum ErrorMessage {
    FORMAT("[ERROR] %s"),
    NUMBER_OF_LOTTO_NUMBERS_IS_6("6개의 로또 번호가 필요합니다."),
    LOTTO_NUMBERS_HAS_NO_DUPLICATE("로또 번호는 중복이 될 수 없습니다."),
    LOTTO_NUMBERS_HAS_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.");

    private String message;

    ErrorMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        String errorFormat = FORMAT.getFormat();

        return String.format(errorFormat, message);
    }

    private String getFormat() {
        return message;
    }
}
