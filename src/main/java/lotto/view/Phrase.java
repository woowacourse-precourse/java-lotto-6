package lotto.view;

public enum Phrase {
    AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_OUTPUT("개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    THREE_MATCH("3개 일치 (5,000원)"),
    FOUR_MATCH("4개 일치 (50,000원)"),
    FIVE_MATCH("5개 일치 (1,500,000원)"),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH("6개 일치 (2,000,000,000원)"),
    DELIMITER("-"),
    COUNT("개"),
    STATISTICS("당첨 통계"),
    REVENUE("총 수익률은 %.1f%%입니다.");


    private String printPhrase;

    Phrase(String printPhrase) {
        this.printPhrase = printPhrase;
    }

    String getPrintPhrase() {
        return this.printPhrase;
    }

}
