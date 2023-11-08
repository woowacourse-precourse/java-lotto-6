package lotto;

public enum Message {

    INPUT_PRICE_MESSAGE("구입금액을 입력해 주세요"),
    INPUT_WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요"),
    NUMBER_OF_LOTTOS_MESSAGE("\n%d개를 구매했습니다.\n"),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다.\n"),
    RESULT_MESSAGE("\n당첨 통계\n---");


    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
