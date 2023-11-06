package lotto.util;

public enum LottoGuideMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_COUNT_INFO("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계");

    private final String message;

    LottoGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
