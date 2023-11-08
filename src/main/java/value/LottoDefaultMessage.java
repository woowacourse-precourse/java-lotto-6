package value;

public enum LottoDefaultMessage {
    TOTAL_SPENDING_AMOUNT_MONEY("구입금액을 입력해 주세요."),
    TOTAL_LOTTO_COUNT("개를 구매했습니다."),
    INSERT_LOTTO_NUMBERS("당첨 번호를 입력해주세요."),
    INSERT_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    RESULT_STATISTICS("당첨 통계\n___"),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE("5개 일치, 보너스볼 일치 (30,000,000원) - "),
    THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE("4개 일치 (50,000원) - "),
    FIFTH_PRIZE("3개 일치 (5,000원) - "),
    TOTAL_EARN_RATIO_START("총 수익률은 "),
    TOTAL_EARN_RATIO_END("%입니다.");

    private final String message;

    LottoDefaultMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}
