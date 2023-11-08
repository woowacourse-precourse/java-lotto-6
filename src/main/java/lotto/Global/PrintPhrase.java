package lotto.Global;

public enum PrintPhrase {
    PURCHASE_INPUT("구입 금액을 입력해 주세요."),
    PURCHASE_RESULT("%d개를 구매했습니다."),
    WINNER_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_INFORMATION_OUTPUT("당첨 통계\n---"),
    RATE_OF_RETURN_RESULT("총 수익률은 %.1f%%입니다.");

    private String phrase;

    private PrintPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getResultState(int value) {
        return String.format(this.phrase, value);
    }

    public String getResultState(float value) {
        return String.format(this.phrase, value);
    }


}
