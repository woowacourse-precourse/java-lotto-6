package lotto.view.constants;

import static lotto.view.constants.SymbolType.NEWLINE;

public enum MessageType {
    COST_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("%s개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계" + NEWLINE.getSymbol() + "---");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
