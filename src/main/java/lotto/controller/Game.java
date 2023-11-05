package lotto.controller;

import lotto.dto.LottosDto;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private final UserService userService = new UserService();
    private final LottoService lottoService = new LottoService();
    private final ResultService resultService = new ResultService();

    public void start() {
        boolean isValidPurchaseAmount = false;
        boolean isValidWinningNumber = false;
        boolean isValidBonusNumber = false;

        while (!isValidPurchaseAmount) {
            String purchaseAmountInput = InputView.inputPurchaseAmount();
            try {
                userService.validatePurchaseAmount(purchaseAmountInput);
                isValidPurchaseAmount = true;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        LottosDto createdLottos = userService.purchaseLottos();
        OutputView.printLottos(createdLottos);

        while (!isValidWinningNumber) {
            String winningNumbers = InputView.inputWinningNumber();
            try {
                lottoService.validateWinningNumber(winningNumbers);
                isValidWinningNumber = true;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }

        while (!isValidBonusNumber) {
            String bonusNumber = InputView.inputBonusNumber();
        }

    }
}
