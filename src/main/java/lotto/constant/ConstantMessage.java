package lotto.constant;

public enum ConstantMessage {
    INPUT_BUY_MONEY("구입금액을 입력해 주세요.\n"),
    BUY_LOTTO_TICKET("개를 구매했습니다.\n"),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요.\n"),
    WINNING_STAT("당첨 통계\n---\n"),
    THREE_CORRECT("3개 일치 (5,000원) - "),
    FOUR_CORRECT("4개 일치 (50,000원) - "),
    FIVE_CORRECT("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_CORRECT("6개 일치 (2,000,000,000원) - "),
    COUNT("개\n");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}