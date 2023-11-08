package lotto.controller;

import lotto.domain.*;
import lotto.util.MathUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private SiteUser siteUser;
    private LottoCompany lottoCompany;
    private WinningStatistics winningStatistics;

    public void startLotto() {
        inputMoney();
        outputLottoCnt();

        inputWinningNumberAndBonusNumber();

        summaryStatistics();

        outputStatistics();
    }

    private void inputMoney() {
        this.siteUser = SiteUser.createSiteUser((int) InputView.INPUT_MONEY.activateView());
        System.out.println();
    }

    private void outputLottoCnt() {
        OutputView.showLottoCnt(this.siteUser.getLottoCnt());
        OutputView.showLotto(this.siteUser.getUserLotto().getLottoTickets());
        System.out.println();
    }

    private void inputWinningNumberAndBonusNumber() {
        List<Integer> numbers;

        numbers = (List<Integer>) InputView.INPUT_WINNING_NUMBER.activateView();
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        System.out.println();

        numbers = (List<Integer>) InputView.INPUT_BONUS_NUMBER.activateView();
        BonusNumbers bonusNumbers = new BonusNumbers(numbers);

        this.lottoCompany = LottoCompany.createLottoCompany(winningNumbers, bonusNumbers);
        System.out.println();
    }

    private void summaryStatistics() {
        this.winningStatistics = WinningStatistics.calculateWinningConditions(
                this.siteUser.getUserLotto(), this.lottoCompany.getWinningNumbers(), this.lottoCompany.getBonusNumbers());

    }

    private void outputStatistics() {
        OutputView.showLottoWinningDetails(this.winningStatistics.getStatistics());
        OutputView.showRateOfReturn(MathUtil.formatPercentage(this.siteUser.getUserMoney().getMoney(),
                MathUtil.getProfit(this.winningStatistics.getStatistics())));
    }

}
