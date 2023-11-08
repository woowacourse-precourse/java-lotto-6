package lotto.model.data;

import lotto.model.record.Money;
import lotto.model.record.NumberOfLotto;

public class LottoPortfolio {
    private LottoRecipe lottoRecipe;
    private WinningPortfolio winningPortfolio;

    public Integer save(Integer amountOfLotto) {
        lottoRecipe = LottoRecipe.of(new Money(amountOfLotto));
        NumberOfLotto numberOfLotto = lottoRecipe.purchaseLotto();

        return numberOfLotto.numberOfLotto();
    }

    public WinningPortfolio addWinning(WinningStatus winningStatus) {
        winningPortfolio = new WinningPortfolio(winningStatus);
        winningPortfolio.updateRateOfReturn(lottoRecipe);

        return winningPortfolio;
    }
}
