package lotto.view;

public enum Message {
    // use in InputView
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),

    // use in OutputView
    BUY("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    DIVISION("---"),
    AGREEMENT_THREE_NUMBERS("3개 일치 (5,000원) - "),
    AGREEMENT_FOUR_NUMBERS("4개 일치 (50,000원) - "),
    AGREEMENT_FIVE_NUMBERS("5개 일치 (1,500,000원) - "),
    AGREEMENT_FIVE_NUMBERS_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    AGREEMENT_SIX_NUMBERS("6개 일치 (2,000,000,000원) - "),
    COUNT("개"),
    TOTAL_RETURN_FIRST("총 수익률은 "),
    TOTAL_RETURN_LAST("입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
