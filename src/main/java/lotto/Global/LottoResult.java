package lotto.Global;

public enum LottoResult {
    PURCHASE_RESULT("%d개를 구매했습니다."),
    FIFTH_RESULT("3개 일치 (5,000원) - %d개", "fifth_result"),
    FOURTH_RESULT("4개 일치 (50,000원) - %d개", "fourth_result"),
    THIRD_RESULT("5개 일치 (1,500,000원) - %d개", "third_result"),
    SECOND_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", "second_result"),
    FIRST_RESULT("6개 일치 (2,000,000,000원) - %d개", "first_result"),
    RATE_OF_RETURN_RESULT("총 수익률은 %d%입니다.", "rate");

    private String resultPhrase;
    private String name;

    private LottoResult(String resultPhrase) {
        this.resultPhrase = resultPhrase;
        this.name = "";
    }

    private LottoResult(String resultPhrase, String name) {
        this.resultPhrase = resultPhrase;
        this.name = name;
    }

    public String getResultState(int value) {
        return String.format(this.resultPhrase, value);
    }

    public String getName() {
        return name;
    }
}
