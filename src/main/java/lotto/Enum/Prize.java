package lotto.Enum;

public enum Prize {
    SIX_CORRECT("6개 일치 (2,000,000,000원)",2000000000),
    FIVE_CORRECT_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIVE_CORRECT_NOT_BONUS("5개 일치 (1,500,000원)", 1500000),
    FOUR_CORRECT("4개 일치 (50,000원)", 50000),
    THREE_CORRECT("3개 일치 (5,000원)", 5000);

    private String tag;
    private int money;
    Prize(String tag, int money) {
        this.tag = tag;
        this.money = money;
    }

    public String getTag() {
        return tag;
    }

    public int getMoney() {
        return money;
    }
}
