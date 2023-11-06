package lotto.domain.exception;

import static lotto.util.Constants.LOTTO_ONE_GAME_PRICE;

public enum BudgetException {
    INVALID_UNIT_OF_BUDGET(String.format("금액은 %d원 단위로 입력해야 합니다.", LOTTO_ONE_GAME_PRICE));

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    BudgetException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
