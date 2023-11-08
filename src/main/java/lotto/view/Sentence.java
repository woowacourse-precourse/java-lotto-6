package lotto.view;

public enum Sentence {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n"),

    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다.\n"),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n"+ "---\n"),
    OUTPUT_WINNING_THREE_MATCHES("3개 일치 (5,000원) - "),
    OUTPUT_WINNING_FOUR_MATCHES("4개 일치 (50,000원) - "),
    OUTPUT_WINNING_FIVE_MATCHES("5개 일치 (1,500,000원) - "),
    OUTPUT_WINNING_FIVE_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_WINNING_SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
    OUTPUT_WINNING_MATCHES_COUNT("개\n"),
    OUTPUT_TOTAL_RETURN_FRONT("총 수익률은 "),
    OUTPUT_TOTAL_RETURN_BACK("%입니다.\n");

    private String sentence;

    Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
