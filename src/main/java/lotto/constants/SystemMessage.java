package lotto.constants;

public enum SystemMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_NUMBER_OF_PURCHASED_LOTTO("개를 구매했습니다."),
    PRINT_WINNING_RESULT("\n당첨 통계\n---"),
    PRINT_RATE_OF_RETURN("총 수익률은 %s%%입니다.");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
