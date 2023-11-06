package lotto.controller;


import lotto.View.ErrorMessageView;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.model.*;

public class LottoController {

    public void start() {
        LottoAmount amount = inputAmount();
        LottoTickets lottoNum = buyLotto(amount);
        WinningNumber winningNum = inputWinningNumber();
        BonusNumber bonusNum = inputBonusNumber(winningNum);
        WinningResult winningResult = calculateWinningResult(lottoNum, winningNum, bonusNum);
        OutputView.printWinningResult(winningResult);
        calculateEarningRate(winningResult, amount);
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

    private LottoTickets buyLotto(LottoAmount amount) {
        amount.getLottoCount();
        LottoTickets lottoTickets = new LottoTickets(amount.getLottoCount());
        OutputView.printLottoCount(amount.getLottoCount());
        OutputView.printLottoTickets(lottoTickets);
        return lottoTickets;
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
            validateDuplicatedNumber(winningNum, bonusNumber);
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

    private WinningResult calculateWinningResult(LottoTickets tickets, WinningNumber winningNum, BonusNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : tickets.getTickets()) {
            int matchCount = lotto.getMatchCount(winningNum);
            boolean hasBonus = lotto.hasBonus(bonusNumber);
            LottoRanking ranking = LottoRanking.determineRanking(matchCount, hasBonus);
            winningResult.addRanking(ranking);
        }
        return winningResult;
    }

    private void calculateEarningRate(WinningResult winningResult, LottoAmount amount) {
        double totalPrize = winningResult.getTotalPrize();
        EarningRate earningRate = new EarningRate(totalPrize, amount);
    }
}
