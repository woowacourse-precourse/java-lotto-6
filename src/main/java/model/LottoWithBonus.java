package model;

public class LottoWithBonus {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public LottoWithBonus(final Lotto lotto, final LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWithBonus createDefault() {
        Lotto lotto = Lotto.createDefault();
        LottoNumber uniqueNumber = lotto.generateUniqueNumber();
        return new LottoWithBonus(lotto, uniqueNumber);
    }

    public LottoCompareResult compareAnswer(final LottoWithBonus answerLotto) {
        long equalCount = lotto.compareLotto(answerLotto.getLotto());
        return new LottoCompareResult(equalCount, hasSameBonusNumber(answerLotto));
    }

    public boolean hasSameBonusNumber(final LottoWithBonus lotto) {
        return bonusNumber.equals(lotto.getBonusNumber());
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
