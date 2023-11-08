package lotto.utils.constants;

public enum Comment {
    INPUT_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_WINNING_STATISTICS("당첨 통계"),
    INPUT_THREE_DASH("---"),
    OUTPUT_FIFTH_PRIZE("3개 일치 (5,000원) - "),
    OUTPUT_FOURTH_PRIZE("4개 일치 (50,000원) - "),
    OUTPUT_THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    OUTPUT_SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    OUTPUT_TOTAL_RETURN("총 수익률은 "),
    OUTPUT_COUNT("개");

    private final String comment;

    Comment(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}

