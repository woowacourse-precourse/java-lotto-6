package lotto.view.constants;

import static lotto.view.constants.SymbolType.NEWLINE;

public enum MessageType {
    WINNING_RESULT_NOTICE("당첨 통계" + NEWLINE.getSymbol() + "---"),
    WINNING_RESULT_INFORMATION("%d개 일치 (%,d원) - %d개"),
    WINNING_RESULT_WITH_BONUS_INFORMATION("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    EARNINGS_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
