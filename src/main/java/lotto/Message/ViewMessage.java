package lotto.Message;

public enum ViewMessage {
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PRINT_NUMBER_OF_PURCHASE("%d개를 구매했습니다."),
    WINNING_NUMBERS_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    PRINT_WINNING_RESULT("당첨 통계"),
    PRINT_LINE_SYMBOL("---"),
    PRINT_TOTAL_REVENUE("총 수익률은 %f%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public  String getMessage() {
        return message;
    }
}