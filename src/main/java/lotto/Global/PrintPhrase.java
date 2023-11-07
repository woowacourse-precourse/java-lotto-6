package lotto.Global;

public enum PrintPhrase {
    PURCHASE_INPUT("구입 금액을 입력해 주세요."),
    WINNER_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_INFORMATION_OUTPUT("당첨 통계\n---");

    private String phrase;

    private PrintPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getStatement() {
        return phrase;
    }

}
