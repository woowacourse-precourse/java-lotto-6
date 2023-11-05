package lotto.message;

public enum LottoMessage {

    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    HOW_MANY_BUY_LOTTO("개를 구매했습니다."),
    INSERT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INSERT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    HORIZONTAL_RULE("---"),
    FIFTH_PLACE("3개 일치 (5,000원) - "),
    FOURTH_PLACE("4개 일치 (50,000원) - "),
    THIRD_PLACE("5개 일치 (1,500,000원) - "),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - "),
    RATE_OF_RETURN_HEAD("총 수익률은 "),
    RATE_OF_RETURN_TAIL("%입니다.");

    private String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
