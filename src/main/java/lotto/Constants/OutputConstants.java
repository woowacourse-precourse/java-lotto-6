package lotto.Constants;

public enum OutputConstants {
    HIT_THREE_NUMBER("3개 일치 (5,000원) - %d개"),
    HIT_FOUR_NUMBER("4개 일치 (50,000원) - %d개"),
    HIT_FIVE_NUMBER("5개 일치 (1,500,000원) - %d개"),
    HIT_FIVE_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    HIT_SIX_NUMBER("6개 일치 (2,000,000,000원) - %d개"),
    LOTTO_RESULT("당첨 통계"),
    TOTAL_LOTTO_TICKETS("%d개를 구매했습니다."),
    CONTOUR("---"),
    TOTAL_LOTTO_PROFIT("총 수익률은 %s%%입니다.");
    private String message;

    OutputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
