package lotto.domain;

public enum LottoScore {
    FIRST_PLACE("6개 일치", "(2,000,000,000원)", 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", "(3,000,000원)", 3000000),
    THIRD_PLACE("5개 일치", "(1,500,000원)", 1500000),
    FOURTH_PLACE("4개 일치", "(50,000원)", 50000),
    FIFTH_PLACE("3개 일치", "(5,000원)", 5000);

    private final String name;
    private final String value;
    private final int money;

    private LottoScore(String name, String value, int money) {
        this.name = name;
        this.value = value;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int getMoney() {
        return this.money;
    }
}
