package lotto.constants;

public enum ResultConfig {
    THREE_COINCIDE("3", "3개 일치 (5,000원) - "),
    FOUR_COINCIDE("4", "4개 일치 (50,000원) - "),
    FIVE_COINCIDE("5", "5개 일치 (1,500,000원) - "),
    FIVE_BONUS_COINCIDE("50", "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_COINCIDE("6", "6개 일치 (2,000,000,000원) - ");

    private final String count;
    private final String message;
    ResultConfig(String count, String meesage) {
        this.count = count;
        this.message = meesage;
    }

    public String getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }
}
