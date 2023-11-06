package lotto.controller;

import lotto.domain.lottoresult.EarningRate;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.WinningNumbers;
import lotto.service.LottoChecker;
import lotto.view.inputview.InputView;
import lotto.view.inputview.InputValueType;
import lotto.view.outputview.OutputView;

public class LottoController {
    private final LottoChecker lottoChecker;

    public LottoController(LottoChecker lottoChecker) {
        this.lottoChecker = lottoChecker;
    }

    public void start() {
        LottoTickets lottoTickets = buyLottoTickets();
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);

        showLottoResult(lottoTickets, winningNumbers, bonusNumber);
    }

    private LottoTickets buyLottoTickets() {
        PurchasePrice purchasePrice = getPurchasePrice();
        LottoTickets lottoTickets = new LottoTickets(purchasePrice);

        OutputView.printLotto(lottoTickets);

        return lottoTickets;
    }

    private void showLottoResult(LottoTickets lottoTickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoCheckResult result = lottoChecker.checkLottoTickets(lottoTickets, winningNumbers, bonusNumber);
        EarningRate rate = lottoChecker.calculateEarningRate(result);

        OutputView.printResult(result, rate);
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        return (BonusNumber) InputView.inputValue(InputValueType.BONUS_NUMBER, winningNumbers);
    }

    private WinningNumbers getWinningNumbers() {
        return (WinningNumbers) InputView.inputValue(InputValueType.WINNING_NUMBERS);
    }

    private PurchasePrice getPurchasePrice() {
        return (PurchasePrice) InputView.inputValue(InputValueType.PURCHASE_PRICE);
    }
}
