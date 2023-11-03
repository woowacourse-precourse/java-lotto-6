package lotto.controller;

import lotto.domain.EarningRate;
import lotto.domain.LottoCheckResult;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.WinningNumbers;
import lotto.exception.domain.bonusnumber.BonusNumberFormatException;
import lotto.service.LottoChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        try {
            String bonusNumber = InputView.inputBonusNumber();
            return BonusNumber.create(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private WinningNumbers getWinningNumbers() {
        try {
            String winningNumbers = InputView.inputWinningNumbers();
            return WinningNumbers.create(winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private PurchasePrice getPurchasePrice() {
        try {
            String money = InputView.inputPurchasePrice();
            return PurchasePrice.create(money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPurchasePrice();
        }
    }
}
