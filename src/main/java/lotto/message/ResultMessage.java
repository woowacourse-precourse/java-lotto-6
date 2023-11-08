package lotto.message;

import lotto.model.LottoRank;

public enum ResultMessage {
    FIRST("6개 일치 (2,000,000,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    FIFTH("3개 일치 (5,000원) - %d개"),
    PROFIT_PERCENTAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
