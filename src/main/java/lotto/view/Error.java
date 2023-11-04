package lotto.view;

public enum Error {
    VALIDATE_PURCHASE_AMOUNTS("[ERROR] 구입 금액은 숫자여야 합니다. 다시 입력해주세요."),
    VALIDATE_LOTTO_NUMBERS("[ERROR] 당첨 번호는 숫자여야 합니다. 다시 입력해주세요."),
    VALIDATE_BONUS_NUMBER("[ERROR] 보너스 번호는 1개의 숫자여야 합니다. 다시 입력해주세요.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
