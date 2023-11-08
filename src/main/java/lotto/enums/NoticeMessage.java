package lotto.enums;

public enum NoticeMessage {
    BUY_MONEY("구입금액을 입력해 주세요."),
    BUY_COUNT("개를 구매했습니다."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계"),
    STRAIGHT_LINE("---"),
    RATE_OF_RETURN_HEAD("총 수익률은 "),
    RATE_OF_RETURN_TAIL("%입니다.");

    private final String message;

    NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
