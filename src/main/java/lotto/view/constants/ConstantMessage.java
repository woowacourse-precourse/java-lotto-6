package lotto.view.constants;

public enum ConstantMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_PURCHASE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESPONSE_PURCHASE_AMOUNT("%d개를 구매했습니다."),
    RESPONSE_WINNING_STATISTICS("당첨 통계"),
    RESPONSE_HYPHEN_SEPARATOR("---"),
    RESPONSE_MATCHING_WINNING_NUMBER("%d개 일치"),
    RESPONSE_MATCHING_BONUS_NUMBER("보너스 볼 일치"),
    RESPONSE_PROFIT_RATE("총 수익률은 %f%입니다.");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
