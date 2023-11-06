package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.ConsoleOutDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();
    public void run() {
        Money money = receiveUserMoney();
        WinningLotto winningLotto = receiveUserBonusNumber(receiveUserStandardNumber());
        ConsoleOutDTO consoleOutDTO = lottoService.respondToRequest(money, winningLotto);
        outputView.printResult(consoleOutDTO);
    }

    private Money receiveUserMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserMoney();
    }

    private Lotto receiveUserStandardNumber() {
        try {
            return new Lotto(inputView.inputWinningLottoStandardNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserStandardNumber();
    }

    private WinningLotto receiveUserBonusNumber(Lotto lotto) {
        try {
            return new WinningLotto(lotto, inputView.inputWinningLottoBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserBonusNumber(lotto);
    }
}
