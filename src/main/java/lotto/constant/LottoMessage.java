package lotto.constant;

public enum LottoMessage {
    INPUT_LOTTO_AMOUNT("구입급액을 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    DIVIDE_LINE("---"),
    CORRECT_MESSAGE("%d개 일치 (%s원) - %d개"),
    CORRECT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    FIRST_PRIZE("2,000,000,000"),
    SECOND_PRIZE("30,000,000"),
    THIRD_PRIZE("1,500,000"),
    FOURTH_PRIZE("50,000"),
    FIFTH_PRIZE("5,000"),
    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
