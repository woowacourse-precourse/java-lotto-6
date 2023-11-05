package lotto.constant;

public enum ProgressMessage {
    PURCHASE_AMOUNT_REQUEST("구입금액을 입력해 주세요."),
    PUBLISHED_NUM_OF_LOTTO("%s개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST("\n보너스 번호를 입력해 주세요.");

    private final String message;

    ProgressMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
