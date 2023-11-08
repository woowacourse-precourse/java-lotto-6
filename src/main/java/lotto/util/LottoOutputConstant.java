package lotto.util;

public enum LottoOutputConstant {
    PURCHASE_MESSAGE("개를 구매했습니다."),
    INPUT_MONEY_MESSAGE("구매할 금액을 입력하세요"),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    PROFIT_RATE_FORMAT("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    LottoOutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
