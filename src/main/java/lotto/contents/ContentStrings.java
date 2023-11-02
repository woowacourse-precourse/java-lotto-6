package lotto.contents;

public enum ContentStrings {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    SPLIT_COMMA(","),
    OUTPUT_DASH("---"),
    OUTPUT_PURCHASED_LOTTOS("개를 구매했습니다."),
    OUTPUT_SPACE("\n");

    private final String value;

    ContentStrings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}