package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.Utils;
import lotto.view.ExceptionMessages;
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
        boolean validInput = true;

        while (validInput) {
            try {
                beforeStart();
                validInput = false;
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessages.STRING_TO_INTEGER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void beforeStart() {
        user = new User(getInputAmount());
        lottoService.buyLottoAll(user);
        printBuyLotto();
    }

    private int getInputAmount() {
        outputView.getInputAmount();
        String userInput = inputView.inputAmount();
        return Utils.stringToInteger(userInput);
    }

    private void printBuyLotto() {
        outputView.printLottoCount(user.getPurchaseAmount() / 1_000);
        for(Lotto lotto : user.getLottos()) {
            outputView.printLottoNumbers(lotto.numbers());
        }
    }
}
