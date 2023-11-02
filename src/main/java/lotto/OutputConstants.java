package lotto;

public enum OutputConstants {
    HIT_THREE_NUMBER("3개 일치 (5000원) - "),
    HIT_FOUR_NUMBER("4개 일치 (50,000원) - "),
    HIT_FIVE_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    HIT_SIX_NUMBER("6개 일치 (2,000,000,000원) - "),
    LOTTO_RESULT("당첨 통계"),
    CONTOUR("---");
    private String message;

    OutputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
