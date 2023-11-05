package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.Utills;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private User user;
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView InputView, OutputView OutputView) {
        this.lottoService = lottoService;
        this.inputView = InputView;
        this.outputView = OutputView;
    }

    public void run() {
        beforeStart();
    }

    private void beforeStart() {
        user = new User(getInputAmount());
        lottoService.buyLottoAll(user);
        printBuyLotto();
    }

    private int getInputAmount() {
        inputView.inputAmount();
        String userInput = readLine().trim();
        return Utills.stringToInteger(userInput);
    }

    private void printBuyLotto() {
        outputView.printLottoCount(user.getPurchaseAmount() / 1_000);
        for(Lotto lotto : user.getLottos()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }
}
