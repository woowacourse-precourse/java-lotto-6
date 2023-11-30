package lotto.domain;

public enum Result {
    THREE("3개 일치 (5,000원)", 5_000, 0),
    FOUR("4개 일치 (50,000원)", 50_000, 0),
    FIVE("5개 일치 (1,500,000원)", 1_500_000, 0),
    BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 0),
    SIX("6개 일치 (2,000,000,000원)", 2_000_000_000, 0);

    private String result;
    private int match;
    private int money;

    Result(String result, int money, int match) {
        this.result = result;
        this.match = match;
        this.money = money;
    }

    public String getResult() {
        return result;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getMoney() {
        return money;
    }
}
