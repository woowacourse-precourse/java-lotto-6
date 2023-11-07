package lotto.view.constants;

import static lotto.view.constants.SymbolType.NEWLINE;

public enum MessageType {
    COST_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_MESSAGE("당첨 통계" + NEWLINE.getSymbol() + "---"),
    WINNING_NUMBERS_MESSAGE("%d개 일치 (%d원)"),
    WINNING_COUNT_MESSAGE("%d개"),
    EARNINGS_RATE_MESSAGE("총 수익률은 %,.1f%입니다.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
