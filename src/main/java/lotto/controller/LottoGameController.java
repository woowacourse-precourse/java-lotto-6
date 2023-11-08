package lotto.controller;

import java.util.Map;
import lotto.common.Ranking;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void start() {
        LottoCount count = getLottoCount();
        LottoTickets lottoTickets = getLottoTickets(count);
        OutputView.printLottoList(lottoTickets);

        Lotto lotto = getLotto();

        WinningNumbers winningNumbers = getWinningNumbers(lotto);

        printGameResult(WinningResult.findRanks(lotto, lottoTickets, winningNumbers), count.getAmount());
    }

    private LottoCount getLottoCount() {
        try {
            String amount = InputView.inputPurchaseAmount();
            return LottoCount.createLottoCount(amount);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getLottoCount();
        }
    }

    private LottoTickets getLottoTickets(LottoCount count) {
        try {
            return LottoTickets.generateTickets(count);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getLottoTickets(count);
        }
    }

    private Lotto getLotto() {
        try {
            String lottoNumbers = InputView.inputPrizeNumber();
            return Lotto.create(lottoNumbers);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getLotto();
        }
    }

    private WinningNumbers getWinningNumbers(Lotto lotto) {
        try {
            String bonusNumber = InputView.inputBonusNumber();
            return WinningNumbers.createWinningNumbers(lotto, bonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getWinningNumbers(lotto);
        }
    }

    private void printGameResult(Map<Ranking, Integer> result, int amount) {
        OutputView.printWinningDetails(result);
        OutputView.printRateOfReturn(WinningResult.getProfit(result, amount));
    }

}
