package lotto.Enum;

public enum Prize {
    SIX_CORRECT("6개 일치 (2,000,000,000원)", "6", 2000000000),
    FIVE_CORRECT_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", "5+1", 30000000),
    FIVE_CORRECT_NOT_BONUS("5개 일치 (1,500,000원)", "5", 1500000),
    FOUR_CORRECT("4개 일치 (50,000원)", "4", 50000),
    THREE_CORRECT("3개 일치 (5,000원)", "3", 5000);

    private final String tag;
    private final int money;
    private final String count;

    Prize(String tag, String count, int money) {
        this.tag = tag;
        this.money = money;
        this.count = count;
    }

    public String getTag() {
        return tag;
    }

    public int getMoney() {
        return money;
    }

    public String getCount() {
        return count;
    }

    public static Prize fromCount(String count) {
        for (Prize prize : Prize.values()) {
            if (prize.count.equals(count)) {
                return prize;
            }
        }
        throw new IllegalArgumentException("[ERROR] " + count + "에 해당하는 상수타입이 없습니다.");
    }
}
