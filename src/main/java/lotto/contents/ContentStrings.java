package lotto.contents;

public enum ContentStrings {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    SPLIT_COMMA(","),
    PERCENTAGE_FORMAT("%.1f"),
    OUTPUT_PURCHASED_LOTTO("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("\n당첨 통계"),
    OUTPUT_DASH("---"),
    OUTPUT_SPACE("\n"),
    OUTPUT_RATE_PREFIX("총 수익률은 "),
    OUTPUT_RATE_SUFFIX("%입니다.");

    private final String value;

    ContentStrings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}