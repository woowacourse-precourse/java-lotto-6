package lotto.view.constants;

public enum ViewConstants {
    REQUEST_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    CHECK_LOTTO_TICKETS("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    SHOW_THE_WINNING_STATISTICS("\n당첨 통계"),
    THREE_MATCH("3개 일치 (5,000원) - "),
    FOUR_MATCH("4개 일치 (50,000원) - "),
    FIVE_MATCH("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ");

    private final String message;

    ViewConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
