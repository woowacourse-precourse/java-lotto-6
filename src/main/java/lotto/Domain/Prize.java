package lotto.Domain;

public enum Prize {
    THIRD("3개 일치 (5,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    FIFTH("5개 일치 (1,500,000원) - "),
    FIFTH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIXTH("6개 일치 (2,000,000,000원) - ");

    private final String message;

    Prize(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
