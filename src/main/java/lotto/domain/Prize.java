package lotto.domain;

public enum Prize {

    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    THIRD("5개 일치 (1,500,000원) - ", 1500000),
    FORTH("4개 일치 (50,000원) - ", 50000),
    FIFTH("3개 일치 (5,000원) - ", 5000),
    UNIT("개", 0);

    private final String message;
    private final long money;

    Prize(String message, long money) {
        this.message = message;
        this.money = money;
    }

    public String getMessage() {
        return message;
    }

    public long getMoney() {
        return money;
    }
}
