package lotto.util;

public enum OutputEnum {

    PUBLISHED_LOTTO_COUNT_OUTPUT("개를 구매했습니다."),
    FIRST_OUTPUT("6개 일치 (2,000,000,000원) - "),
    SECOND_OUTPUT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_OUTPUT("5개 일치 (1,500,000원) - "),
    FOURTH_OUTPUT("4개 일치 (50,000원) - "),
    FIFTH_OUTPUT("3개 일치 (5,000원) - "),
    COUNT_UNIT("개"),
    ROI_OUTPUT_PREFIX("총 수익률은 "),
    ROI_OUTPUT_SUFFIX("%입니다.");

    private String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
