package lotto.lotto;

public enum LottoResult {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FORTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000);

    int rank;
    int target;
    boolean bonusTarget;
    int reward;

    LottoResult(int rank, int target, boolean bonusTarget, int reward) {
        this.rank = rank;
        this.target = target;
        this.bonusTarget = bonusTarget;
        this.reward = reward;
    }
}
