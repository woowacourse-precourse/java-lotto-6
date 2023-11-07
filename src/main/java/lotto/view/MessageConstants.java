package lotto.view;

public enum MessageConstants {
    INPUT_MESSAGE_FOR_BUY_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_MESSAGE_FOR_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_MESSAGE_FOR_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_MESSAGE_FOR_BUY_AMOUNT("%d개를 구매했습니다."),
    OUTPUT_MESSAGE_FOR_RESULT_INIT("당첨 통계"),
    OUTPUT_MESSAGE_FOR_LINE_SEPARATOR("---"),
    OUTPUT_MESSAGE_FOR_LOTTO_FORMAT("[%s]"),
    LOTTO_NUMBER_SEPARATOR(", "),
    OUTPUT_MESSAGE_FOR_RESULT_WITHOUT_BONUS("%d개 일치 (%,d원) - %d개"),
    OUTPUT_MESSAGE_FOR_RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    OUTPUT_MESSAGE_FOR_EARNING_RATIO("총 수익률은 %.1f입니다.");


    private final String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
