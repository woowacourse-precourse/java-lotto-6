package lotto.domain.money;

import static lotto.domain.money.LottoMoneyConfig.LOTTO_COST;

public enum LottoMoneyErrorMessage {

    MONEY_NOT_MORE_THAN_ZERO("[ERROR] 0 이하의 금액은 입력할 수 없습니다."),
    MONEY_CANNOT_BE_DIVIDED(String.format("[ERROR] 입력한 금액은 %d원 단위여야 합니다.", LOTTO_COST.getValue()));

    private final String message;

    LottoMoneyErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
