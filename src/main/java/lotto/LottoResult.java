package lotto;

public enum LottoResult {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final Integer prize;
    LottoResult(Integer prize) {
        this.prize = prize;
    }

    public Integer prize() {
        return prize;
    }
}
