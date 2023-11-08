package lotto.Global;

public enum LottoResult {

    FIFTH_RESULT("3개 일치 (5,000원) - %d개"),
    FOURTH_RESULT("4개 일치 (50,000원) - %d개"),
    THIRD_RESULT("5개 일치 (1,500,000원) - %d개"),
    SECOND_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_RESULT("6개 일치 (2,000,000,000원) - %d개");

    private String resultPhrase;

    private LottoResult(String resultPhrase) {
        this.resultPhrase = resultPhrase;
    }


    public String getResultState(int value) {
        return String.format(this.resultPhrase, value);
    }

}
