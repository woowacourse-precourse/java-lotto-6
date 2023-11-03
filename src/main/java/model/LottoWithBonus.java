package model;

public class LottoWithBonus {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private LottoWithBonus(final Lotto lotto, final LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWithBonus createDefault() {
        Lotto lotto = Lotto.createDefault();
        LottoNumber uniqueNumber = lotto.generateUniqueNumber();
        return new LottoWithBonus(lotto, uniqueNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
