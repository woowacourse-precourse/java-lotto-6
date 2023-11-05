package lotto.controller;


import lotto.View.ErrorMessageView;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.model.BonusNumber;
import lotto.model.LottoAmount;
import lotto.model.LottoTickets;
import lotto.model.WinningNumber;

public class LottoController {

    public void start() {
        LottoAmount amount = inputAmount();
        buyLotto(amount);
        WinningNumber winningNum = inputWinningNumber();
        inputBonusNumber(winningNum);
    }

    private LottoAmount inputAmount() {
        try {
            String LottoAmount = InputView.inputLottoAmount();
            return new LottoAmount(LottoAmount);
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printErrorWrongAmount();
            return inputAmount();
        }
    }

    private void buyLotto(LottoAmount amount) {
        amount.getLottoCount();
        LottoTickets lottoTickets = new LottoTickets(amount.getLottoCount());
        OutputView.printLottoCount(amount.getLottoCount());
        OutputView.printLottoTickets(lottoTickets);
    }

    private WinningNumber inputWinningNumber() {
        try {
            String winningNum = InputView.inputWinningLottoNumbers();
            return new WinningNumber(winningNum);
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printErrorWrongNumberRange();
            return inputWinningNumber();
        }
    }

    private BonusNumber inputBonusNumber(WinningNumber winningNum) {
        try {
            String bonusNum = InputView.inputBonusNumber();
            BonusNumber bonusNumber = new BonusNumber(bonusNum);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printErrorWrongNumberRange();
            return inputBonusNumber(winningNum);
        }
    }

    private void validateDuplicatedNumber(WinningNumber winningNum, BonusNumber bonusNumber) {
        if (winningNum.getWinningNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
