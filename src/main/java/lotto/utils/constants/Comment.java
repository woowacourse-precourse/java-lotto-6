package lotto.utils.constants;

public enum Comment {
    INPUT_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_WINNING_STATISTICS("당첨 통계"),
    INPUT_THREE_DASH("---");

    private final String comment;

    Comment(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}

