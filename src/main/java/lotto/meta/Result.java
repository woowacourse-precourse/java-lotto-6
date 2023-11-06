package lotto.meta;

public enum Result {
    ETC(0, 0, 0, "3개 미만 일치 (0월)"),
    THREE(3, 0, 5000, "3개 일치 (5,000원)"),
    FOUR(4, 0, 50000, "4개 일치 (50,000원)"),
    FIVE(5, 0, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 0, 2000000000, "6개 일치 (2,000,000,000원)");

    private int first;
    private int bonus;
    private long sumMoney;
    private String text;
    // TODO ADD ENUM MAP?

    Result(int first, int bonus, long sumMoney, String text) {
        this.first = first;
        this.bonus = bonus;
        this.sumMoney = sumMoney;
        this.text = text;
    }

    public static Result getResult(int first, int bonus) {
        for (Result result : Result.values()) {
            if (result.getFirst() == first && result.getBonus() == bonus) {
                return result;
            }
        }

        return Result.ETC;
    }

    public int getFirst() {
        return first;
    }

    public int getBonus() {
        return bonus;
    }

    public long getSumMoney() {
        return sumMoney;
    }

    public String getText() {
        return text;
    }
}
