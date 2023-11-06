package lotto.enums;

public enum Message {
    AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO("개를 구매했습니다."),
    WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println(message);
    }
}
