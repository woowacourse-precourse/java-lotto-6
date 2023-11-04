package lotto.constants;

public enum Phrase {
    INPUT_LOTTO_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_LOTTO_AMOUNT("\n%d개를 구매했습니다."),
    INPUT_LOTTO_PRIZE("\n당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS("\n보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_RESULT("\n당첨 통계\n---");

    private final String phrase;

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public String formatAmount(int amount) {
        return String.format(phrase, amount);
    }
}
