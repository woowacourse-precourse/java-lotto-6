package lotto.domain;

public enum WinLottoResult {
    THREE("three"),
    FOUR("four"),
    FIVE("five"),
    FIVE_BONUS("five_bonus"),
    SIX("six");

    private String name;
    private int count;

    WinLottoResult(String name) {
        this.name = name;
        this.count = 0;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
