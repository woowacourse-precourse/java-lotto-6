package lotto.message;

public enum ErrorMessage {
    NUMBER_SIZE("[ERROR] 숫자는 6개가 되어야 합니다."),
    NUMBER_RANGE("[ERROR] 1과 45 사이의 숫자만 가능합니다."),
    NUMBER_DUPLICATION("[ERROR] 중복된 숫자가 존재합니다."),
    MONEY_AMOUNT("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다."),
    DUPLICATION_BONUS("[ERROR] 당첨 번호와 보너스 번호는 서로 중복된 숫자가 없어야 합니다."),
    ONLY_NUMBER_USING("[ERROR] 숫자만 입력하세요"),
    NUMBER_COMMA_USING("[ERROR] 숫자와 쉼표(,)만 입력하세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
