package lotto.constant;

public enum ErrorMessage {

    LOTTO_NUMBER_LENGTH("[ERROR] 당첨 번호는 쉼표로 구분된 여섯개의 숫자여야 합니다."),
    LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1이상 45이하의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복되지 않은 여섯개의 숫자여야 합니다."),
    BONUS_DUPLICATE_WITH_LOTTO("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    PURCHASE_MONEY_NOT_BIGGER_THAN_ZERO("[ERROR] 구입금액은 0보다 큰 숫자여야 합니다."),
    PURCHASE_MONEY_NOT_MULTIPLE_OF_1000("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}