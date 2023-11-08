package lotto.model.data;

import lotto.model.record.Money;
import lotto.model.record.NumberOfLotto;

/**
 * 구입 내역과 당첨 결과에 대한 정보를 가지고 있는 포트폴리오를 나타낸다.
 */
public class LottoPortfolio {
    private LottoRecipe lottoRecipe;
    private WinningPortfolio winningPortfolio;

    /**
     * 투자금을 기반으로 구입한 로또의 영수증을 생성한다.
     * 투자금으로 구입할 수 있는 로또의 개수로 LottoRecipe를 초기화한다.
     *
     * @param amountOfInvestment 투자금
     * @return 투자금으로 구입할 수 있는 로또의 개수
     */
    public Integer createPayRecipe(int amountOfInvestment) {
        lottoRecipe = LottoRecipe.from(new Money(amountOfInvestment));
        NumberOfLotto numberOfLotto = lottoRecipe.purchaseLotto();

        return numberOfLotto.numberOfLotto();
    }

    /**
     * 당첨 내역을 저장하고 당첨 포트폴리오에 수익률을 업데이트한다.
     * 로또를 구입하고 당첨 내역이 발생했을 때 호출된다.
     *
     * @param winningStatus 로또 번호에 대한 당첨 내역
     * @return 수익률이 업데이트 된 WinningPortfolio
     */
    public WinningPortfolio saveWinningStatus(WinningStatus winningStatus) {
        winningPortfolio = new WinningPortfolio(winningStatus);
        winningPortfolio.updateRateOfReturn(lottoRecipe);

        return winningPortfolio;
    }
}
