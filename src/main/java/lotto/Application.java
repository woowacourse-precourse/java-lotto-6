package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.LottoMachine;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoMachine(), new InputView());

        int purchaseAmount = lottoController.inputPurchaseAmount();
        List<Lotto> lottoTickets = lottoController.generateLottoTickets(purchaseAmount);

        List<Integer> winningNumbers = lottoController.inputWinningNumbers();
        int bonusNumber = lottoController.inputBonusNumber();

        WinningResult winningResult = lottoController.calculateWinningResult(lottoTickets, winningNumbers, bonusNumber);

        lottoController.showResult(lottoTickets, winningResult);
    }
}