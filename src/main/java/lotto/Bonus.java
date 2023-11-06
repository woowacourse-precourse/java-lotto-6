package lotto;

public class Bonus {
    private final LottoType lottoType;
    private final Integer bonusNumber;

    public Bonus() {
        this(LottoType.NORMAL, 0);
    }

    public Bonus(Integer bonusNumber) {
        this(LottoType.JACKPOT, bonusNumber);
    }

    public Bonus(LottoType lottoType, Integer bonusNumber) {
        this.lottoType = lottoType;
        this.bonusNumber = bonusNumber;
    }

    public static Bonus emptyBonus() {
        return new Bonus(null, null);
    }

    public boolean isJackpot() {
        return lottoType == LottoType.JACKPOT;
    }

    public boolean isEmpty() {
        return lottoType == null;
    }
}
