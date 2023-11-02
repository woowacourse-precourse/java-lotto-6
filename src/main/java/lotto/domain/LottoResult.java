package lotto.domain;

public enum LottoResult {

    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private int count;
    private boolean validBonus;
    private int prize;

    LottoResult(int count, boolean validBonus, int prize) {
        this.count = count;
        this.validBonus = validBonus;
        this.prize = prize;
    }

}