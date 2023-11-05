package lotto.view.constants;

public enum PrintMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    RETURN_LOTTO_AMOUNT("개를 구매했습니다."),
    RETURN_LOTTO_STATS("당첨 통계" + "\n" + "---" + "\n");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
