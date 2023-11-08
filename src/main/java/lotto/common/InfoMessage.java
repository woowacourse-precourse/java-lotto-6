package lotto.common;

public enum InfoMessage {
    PURCHASE_PRICE_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY("\n%d개를 구매했습니다.\n"),
    WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.")
    ;

    InfoMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
