package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.view.Input;
import lotto.view.Output;

public class GameService {

    private Input input = new Input();
    private Output output = new Output();

    public void play() {
        IssuedLotto issuedLotto = getInputAndCreateIssuedLotto();
        printLottoQuantityAndNumbers(issuedLotto);
        WinningLotto winningLotto = getInputAndCreateWinningLotto();
        LottoRank lottoRank = getLottoRank(issuedLotto, winningLotto);
        printWinningProcess(lottoRank, issuedLotto);
    }

    private LottoRank getLottoRank(IssuedLotto issuedLotto, WinningLotto winningLotto) {
        WinningStatistics winningStatistics = getWinningStatistics(issuedLotto, winningLotto);
        return getCalculatedLottoRank(winningStatistics);
    }

    private LottoRank getCalculatedLottoRank(WinningStatistics winningStatistics) {
        LottoRank lottoRank = new LottoRank();
        lottoRank.calculateRanking(winningStatistics);
        return lottoRank;
    }

    private WinningStatistics getWinningStatistics(IssuedLotto issuedLotto, WinningLotto winningLotto) {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateWinning(issuedLotto, winningLotto);
        return winningStatistics;
    }

    private void printWinningProcess(LottoRank lottoRank, IssuedLotto issuedLotto) {
        output.printWinningStatistics();
        output.printWinningDetails(lottoRank.convertToString());
        output.printTotalReturn(lottoRank.getTotalEarningRate(issuedLotto.getAmount()));
    }

    private void printLottoQuantityAndNumbers(IssuedLotto issuedLotto) {
        output.printLottoQuantity(issuedLotto.getAmount());
        output.printLottoNumbers(issuedLotto);
    }

    private IssuedLotto getInputAndCreateIssuedLotto() {
        try {
            return new IssuedLotto(input.askAmountOfLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputAndCreateIssuedLotto();
        }
    }

    private WinningLotto getInputAndCreateWinningLotto() {
        try {
            return new WinningLotto(input.askWinningNumber(), input.askBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputAndCreateWinningLotto();
        }
    }
}
