package lotto.constants;

public enum ErrorMessages {
    LOTTO_PURCHASE_AMOUNT_NUMERIC_ONLY("로또 구입 금액은 숫자만 입력 가능 합니다."),
    LOTTO_PURCHASE_AMOUNT_UNIT("로또 구입금액 단위는 %d원 입니다."),
    LOTTO_PURCHASE_AMOUNT_MAX("최대로 입력할수 있는 로또 구입금액은 %d 입니다."),

    LOTTO_NUMBERS_NUMERIC_ONLY("로또 번호는 숫자여야 합니다."),
    LOTTO_NUMBERS_COUNT("로또 번호 개수는 %d개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("로또 번호는 중복이 될수 없습니다."),
    LOTTO_NUMBErS_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),

    WINNING_NUMBERS_NUMERIC_ONLY("당첨 번호는 숫자여야 합니다."),
    WINNING_NUMBERS_COUNT("당첨 번호 개수는 %d개여야 합니다."),
    WINNING_NUMBERS_DUPLICATE("당첨 번호는 중복이 될수 없습니다."),
    WINNING_NUMBERS_RANGE("당첨 번호는 %d부터 %d 사이의 숫자여야 합니다."),

    BONUS_NUMBER_NUMERIC_ONLY("보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    BONUS_NUMBER__DUPLICATE("보너스 번호는 당첨번호와 중복될 수 없습니다.");

    private final String message;
    private final String ERROR_TITLE = "[ERROR] ";

    ErrorMessages(String message) {
        this.message = String.join("", ERROR_TITLE, message, System.lineSeparator());
    }

    public String getMessage() {
        return message;
    }
}
