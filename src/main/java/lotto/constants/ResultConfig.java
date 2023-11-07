package lotto.constants;

public enum ResultConfig {
    THREE_COINCIDE("3개 일치 (5,000원) - "),
    FOUR_COINCIDE("4개 일치 (50,000원) - "),
    FIVE_COINCIDE("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_COINCIDE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_COINCIDE("6개 일치 (2,000,000,000원) - ");

    private final String message;
    ResultConfig(String meesage) {
        this.message = meesage;
    }

    public String getMessage() {
        return message;
    }
}
