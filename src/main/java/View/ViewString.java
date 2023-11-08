package View;

public enum ViewString {
    PURCHASE_NOTIFICATION(""),
    THREE_MATCH_NOTIFICATION("3개 일치 (5,000원) - "),
    FOUR_MATCH_NOTIFICATION("4개 일치 (50,000원) - "),
    FIVE_MATCH_NOTIFICATION("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_MATCH_NOTIFICATION("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH_NOTIFICATION("6개 일치 (2,000,000,000원) -"),
    INPUT_PRICE_NOTIFICATION("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_NOTIFICATION("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_NOTIFICATION("보너스 번호를 입력해 주세요.");

    private final String SENTENCE;

    ViewString(String sentence) {
        this.SENTENCE = sentence;
    }

    public String getSentence() {
        return this.SENTENCE;
    }
}
