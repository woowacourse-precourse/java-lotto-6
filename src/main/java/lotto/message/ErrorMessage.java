package lotto.message;

public enum ErrorMessage {
    PURCHASE_PRICE_NOT_NUMBER("[ERROR] 구입 금액은 숫자만 가능합니다."),
    PURCHASE_PRICE_NOT_POSSIBLE("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다."),
    WINNING_NUMBER_SIZE_OVER("[ERROR] 로또 번호는 6개까지 입력할 수 있습니다."),
    WINNING_NUMBER_IS_DUPLICATE("[ERROR] 중복된 숫자를 입력할 수 없습니다."),
    WINNING_NUMBER_NOT_ARRANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER("[ERROR] 보너스 번호는 0 이상의 양수여야 합니다."),
    BONUS_NUMBER_NOT_ARRANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
