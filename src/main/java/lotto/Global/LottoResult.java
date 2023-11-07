package lotto.Global;

public enum LottoResult {
    PURCHASE_RESULT("%d개를 구매했습니다."),
    FIFTH_RESULT("3개 일치 (5,000원) - %d개"),
    FOURTH_RESULT("4개 일치 (50,000원) - %d개"),
    THIRD_RESULT("5개 일치 (1,500,000원) - %d개"),
    SECOND_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_RESULT("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN_RESULT("총 수익률은 %d%입니다.");

    private String resultPhrase;

    private LottoResult(String resultPhrase) {
        this.resultPhrase = resultPhrase;
    }

    public String getResultState(int value) {
        return String.format(this.resultPhrase, value);
    }
}
