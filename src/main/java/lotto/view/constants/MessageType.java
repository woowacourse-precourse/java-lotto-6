package lotto.view.constants;

import static lotto.view.constants.SymbolType.NEWLINE;

public enum MessageType {
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
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
