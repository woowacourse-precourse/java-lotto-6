package lotto.constants;

public enum Phrase {
    INPUT_LOTTO_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_LOTTO_AMOUNT("개를 구매했습니다.");

    private final String phrase;

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
