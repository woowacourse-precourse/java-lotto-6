package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import lotto.Lotto;
import model.LottoGenerator;
import view.LotoInputRequester;

class InputHelperController {

    private InputMan inputMan;
    private LotoInputRequester requester;

    public InputHelperController(InputMan inputMan, LotoInputRequester requester) {
        this.inputMan = inputMan;
        this.requester = requester;
    }

    public Integer checkAndRetryMoneyInput() {
        requester.requestHowMany();
        return ExceptionHandler.handleException(inputMan::receiveMoney);
    }

    private Integer[] checkAndRetryNumbersInput() {
        requester.requestNumbers();
        return ExceptionHandler.handleException(inputMan::receiveNumbers);
    }

    public Lotto proceedtoMakingLotto() {
        return ExceptionHandler.handleException(() -> {
            Integer[] userNumbers = checkAndRetryNumbersInput();
            return LottoGenerator.generateLotto(userNumbers);
        });
    }

    public int checkAndRetryBonusNumberInput(Lotto userLotto) {
        requester.requestBonusNumber();
        return ExceptionHandler.handleException(() -> inputMan.receiveBonusNumber(userLotto));
    }
}
