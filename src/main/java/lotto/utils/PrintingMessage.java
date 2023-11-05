package lotto.utils;

public enum PrintingMessage {
    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    BUYING_MESSAGE("%d개를 구매했습니다."),
    GET_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    PrintingMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String getWithFormat(int number) {
        return String.format(message, number);
    }
}
