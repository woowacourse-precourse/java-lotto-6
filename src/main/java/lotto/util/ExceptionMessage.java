package lotto.util;

public enum ExceptionMessage {
    LOTTO_PURCHASE_AMOUNT_DIVIDE("[ERROR] 로또 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    WIN_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WIN_LOTTO_OVERLAP("[ERROR] 로또 번호는 중복되면 안됩니다."),
    WIN_LOTTO_NUMBER("[ERROR] 로또 번호는 6개여야 합니다."),
    WIN_LOTTO_BONUS_NUMBER("[ERROR] 로또 보너스 번호는 1개여야 합니다."),
    WIN_LOTTO_INTEGER("[ERROR] 로또 번호는 숫자여야 합니다."),
    WIN_LOTTO_SPLIT_UNIT("[ERROR] 로또 번호 구분은 쉼표(,)여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

