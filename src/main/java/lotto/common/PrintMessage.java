package lotto.common;

public enum PrintMessage {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요.");


    private String message;

    PrintMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}
