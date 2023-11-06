package lotto.model;

public enum LottoPrize {
	THREE_MATCHES(5000),    // 3개 번호가 일치할 때의 상금
    FOUR_MATCHES(50000),    // 4개 번호가 일치할 때의 상금
    FIVE_MATCHES(1500000),  // 5개 번호가 일치할 때의 상금
    SIX_MATCHES(2000000000); // 6개 번호가 일치할 때의 상금

    private final int prizeAmount;

    LottoPrize(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
