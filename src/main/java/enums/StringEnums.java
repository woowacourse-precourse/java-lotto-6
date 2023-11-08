package enums;

public enum StringEnums {

    PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    PURCHASE_RESULT("개를 구매했습니다."),
    WIN_LOTTO_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    STATICS_HEADER("당첨 통계\n---"),
    TRIPLE("3개 일치 (5,000원) - "),
    QUADRA("4개 일치 (50,000원) - "),
    PENTA("5개 일치 (1,500,000원) - "),
    PENTA_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    HEXA("6개 일치 (2,000,000,000원) - "),
    UNIT("개"),
    EARN_RATE_HEADER("총 수익률은 "),
    EARN_RATE_FOOTER("%입니다.");


    private final String text;

    StringEnums(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
