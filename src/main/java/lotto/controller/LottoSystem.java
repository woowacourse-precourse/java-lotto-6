package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.ClientLotto;
import lotto.domain.WinningLotto;
import lotto.validator.InputValidator;
import lotto.view.OutputView;

public class LottoSystem {

    private ClientLotto clientLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    private final InputValidator inputValidator = new InputValidator();
    
    public void run() {
        try {
            initiate();
            inputValidator.checkBonusNumber(bonusNumber, winningLotto);
            ResultController resultController = new ResultController();
            resultController.makeResults(winningLotto, clientLotto, bonusNumber);
            resultController.printResult();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void initiate() {
        clientLotto = new ClientLotto();
        winningLotto = new WinningLotto();
        bonusNumber = new BonusNumber();
    }
}
