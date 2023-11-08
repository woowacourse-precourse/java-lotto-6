package lotto.constants;

public enum ResultConfig {
    THREE_COINCIDE("3", "3개 일치 (5,000원) - ", 5_000),
    FOUR_COINCIDE("4", "4개 일치 (50,000원) - ", 50_000),
    FIVE_COINCIDE("5", "5개 일치 (1,500,000원) - ", 1_500_000),
    FIVE_BONUS_COINCIDE("50", "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    SIX_COINCIDE("6", "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private final String count;
    private final String message;
    private final int amount;
    ResultConfig(String count, String meesage, int amount) {
        this.count = count;
        this.message = meesage;
        this.amount = amount;
    }

    public String getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    public int getAmount() {
        return amount;
    }
}
