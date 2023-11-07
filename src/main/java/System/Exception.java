package System;

public enum Exception {
    LOTTO_PURCHASE_EXCEPTION("로또 구매 금액은 1,000원 단위로 입력해주세요."),
    LOTTO_SIZE_EXCEPTION("로또 번호는 6개 보다 크거나 작을 수 없습니다."),
    LOTTO_DUPLICATE_NUMBER_EXCEPTION("로또 번호 중 중복 값은 있을 수 없습니다."),
    RAFFLE_WRONG_INPUT_EXCEPTION("당첨 번호는 6개로 ,를 통해 구분하여 입력해주세요."),
    RAFFLE_WRONG_NUMBER_EXCEPTION("당첨 번호는 1에서 45까지의 숫자 중 입력해주세요."),
    RAFFLE_DUPLICATE_NUMBER_EXCEPTION("당첨 번호 중 중복 값이 없도록 입력해주세요."),
    RAFFLE_DUPLICATE_BONUS_NUMBER_EXCEPTION("당첨 번호와 보너스 번호가 중복이 되지 않게 입력해주세요.");

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

    private final String message;
}
