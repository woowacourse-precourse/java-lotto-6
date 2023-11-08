package lotto;

public enum LottoResult {
    FIRST(0, 2000000000),
    SECOND(1, 30000000),
    THIRD(2, 1500000),
    FOURTH(3, 50000),
    FIFTH(4, 5000),
    FAIL(5, 0);

    private final Integer index;
    private final Integer prize;
    LottoResult(Integer index, Integer prize) {
        this.index = index;
        this.prize = prize;
    }

    public Integer index() { return index; }
    public Integer prize() {
        return prize;
    }
}
