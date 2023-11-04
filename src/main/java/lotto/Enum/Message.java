package lotto.Enum;

public enum Message {
    REQUEST_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INFORM_QUANTITY_MESSAGE("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    SHOW_RESULT("당첨 통계"),
    DIVIDING_LINE("---"),
    THREE_WIN_MESSAGE("3개 일치 (5,000원) - "),
    FOUR_WIN_MESSAGE("4개 일치 (50,000원) - "),
    FIVE_WIN_MESSAGE("5개 일치 (1,500,000원) - "),
    FIVE_WIN_WITH_BONUS_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    LOTTO_WIN_MESSAGE("6개 일치 (2,000,000,000원) - ");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
