package lotto.model.data;

import lotto.model.record.Money;
import lotto.model.record.NumberOfLotto;

public class LottoPortfolio {
    private LottoRecipe lottoRecipe;
    private WinningPortfolio winningPortfolio;

    public Integer createPayRecipe(int amountOfInvestment) {
        lottoRecipe = LottoRecipe.from(new Money(amountOfInvestment));
        NumberOfLotto numberOfLotto = lottoRecipe.purchaseLotto();

        return numberOfLotto.numberOfLotto();
    }

    public WinningPortfolio saveWinningStatus(WinningStatus winningStatus) {
        winningPortfolio = new WinningPortfolio(winningStatus);
        winningPortfolio.updateRateOfReturn(lottoRecipe);

        return winningPortfolio;
    }
}
