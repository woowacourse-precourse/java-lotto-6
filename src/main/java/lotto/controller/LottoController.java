package lotto.controller;

import lotto.domain.LottoCompany;
import lotto.domain.SiteUser;
import lotto.domain.WinningStatistics;
import lotto.util.MathUtil;
import lotto.view.OutputView;

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
        this.siteUser = SiteUser.createSiteUser();
        System.out.println();
    }

    private void outputLottoCnt() {
        OutputView.showLottoCnt(this.siteUser.getLottoCnt());
        OutputView.showLotto(this.siteUser.getUserLotto().getLottoTickets());
        System.out.println();
    }

    private void inputWinningNumberAndBonusNumber() {
        this.lottoCompany = LottoCompany.createlottoCompany();
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
