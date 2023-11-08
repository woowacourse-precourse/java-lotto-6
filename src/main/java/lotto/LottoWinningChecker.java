package lotto;

public class LottoWinningChecker {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private final LottoResultManager lottoResultManager = new LottoResultManager();

    LottoWinningChecker(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult check(Lotto lotto) {
        int matchCount = winningLotto.compareLottoNumber(lotto);
        boolean containBonusNumber = lotto.containLottoNumber(bonusNumber.getLottoNumber());

        LottoResult lottoResult = LottoRule.of(matchCount, containBonusNumber);
        lottoResultManager.add(lottoResult);
        return lottoResult;
    }

    public LottoResultManager getLottoResultManager(){
        return this.lottoResultManager;
    }
}
