package lotto.service;

public enum LottoError {
    LOTTO_INPUT_FAILED_PRICE("[ERROR] 로또 구입 금액은 숫자여야 합니다."),
    LOTTO_INPUT_FAILED_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    LOTTO_PRICE("[ERROR] 로또 구입 금액은 1000원 단위 입니다."),
    LOTTO_NUMBER_COUNT("[ERROR] 로또 당첨 번호는 6개 입니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자입니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    LOTTO_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자입니다."),
    LOTTO_BONUS_NUMBER_COUNT("[ERROR] 보너스 번호는 1개 입니다.");

    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
