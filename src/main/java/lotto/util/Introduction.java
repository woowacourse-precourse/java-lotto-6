package lotto.util;

public enum Introduction {
    INPUT_AMOUNT_OF_LOTTO("구입금액을 입력해 주세요."),
    AMOUNT_OF_LOTTO_PURCHASE("%d개를 구매했습니다."),

    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    WINNING_STATISTICS("당첨 통계"),
    NOT_BONUS_PRIZE_LIST("%d개 일치 (%s원) - %d개"),
    BONUS_PRIZE_LIST("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),

    RATE_OF_RETURN("총 수익률은 %s입니다."),

    SEPARATOR("---"),
    DELIMITER(","),
    LOTTO_PRINT_START("["),
    LOTTO_PRINT_END("]");

    private final String introduction;

    Introduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }
}
