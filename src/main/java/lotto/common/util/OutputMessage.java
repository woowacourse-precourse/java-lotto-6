package lotto.common.util;

public enum OutputMessage {
    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계\n---"),
    RANK_FIVE_RESULT("3개 일치 (5,000원) - %d개"),
    RANK_FOUR_RESULT("4개 일치 (50,000원) - %d개"),
    RANK_THREE_RESULT("5개 일치 (1,500,000원) - %d개"),
    RANK_TWO_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RANK_ONE_RESULT("6개 일치 (2,000,000,000원) - %d개"),
    RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int count) {
        return String.format(this.message, count);
    }

    public String getMessage(double rate) {
        return String.format(this.message, rate);
    }
}
