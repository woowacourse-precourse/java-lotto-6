package lotto.view;

public enum ViewMessage {

    INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_LOTTO_PURCHASE_COUNT("%d개를 구매했습니다."),
    OUTPUT_LOTTO_NUMBERS_DELIMITER(", "),
    OUTPUT_LOTTO_NUMBERS("[%s]"),
    OUTPUT_LOTTO_WINNING_STATISTICS("당첨 통계\n---"),
    OUTPUT_LOTTO_THREE_NUMBER_MATCH("3개 일치 (5,000원) - %d개"),
    OUTPUT_LOTTO_FOUR_NUMBER_MATCH("4개 일치 (50,000원) - %d개"),
    OUTPUT_LOTTO_FIVE_NUMBER_MATCH("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_LOTTO_FIVE_NUMBER_BONUS_NUMBER_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_LOTTO_SIX_NUMBER_MATCH("6개 일치 (2,000,000,000원) - %d개"),
    OUTPUT_LOTTO_RETURNS("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
