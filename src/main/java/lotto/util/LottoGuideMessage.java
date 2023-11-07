package lotto.util;

public enum LottoGuideMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_COUNT_INFO_FORMAT("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    PRIZE_DESCRIPTION_FORMAT("%s (%s원) - %d개"),
    RATE_OF_RETURN_FORMAT("총 수익률은 %s%%입니다.");

    private final String message;

    LottoGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
