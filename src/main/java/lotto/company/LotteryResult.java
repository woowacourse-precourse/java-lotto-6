package lotto.company;

public class LotteryResult {
    private final Lotto lotto;
    private final int bonusNumber;

    private LotteryResult(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LotteryResult from(Lotto lotto, int bonusNumber) {
        return new LotteryResult(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
