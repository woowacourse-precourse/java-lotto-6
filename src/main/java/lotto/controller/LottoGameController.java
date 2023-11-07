package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.exception.InputExceptionConstant;
import lotto.service.LottoGameService;
import lotto.util.InputValidator;
import lotto.util.LottoGameUtil;
import lotto.view.InputView;

public class LottoGameController {

    private final InputView inputView;
    private final LottoGameService service;

    public LottoGameController(InputView inputView, LottoGameService service) {
        this.inputView = inputView;
        this.service = service;
    }

    public void run() {
        initGame();
    }

    private void initGame() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        WinningNumbers winningNumbers = setWinningNumbers();
        BonusNumber bonusNumber = setBonusNumber();
    }

    private BonusNumber setBonusNumber() {
        while (true) {
            try {
                String input = inputView.inputPurchaseAmount();
                InputValidator.validatePurchaseNumber(input);

                int number = LottoGameUtil.StringToInt(input);

                return new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING);
            }
        }
    }

    private WinningNumbers setWinningNumbers() {
        while (true) {
            try {
                String[] inputArray = inputView.inputWinningNumbers();
                InputValidator.isNaturalNumbers(inputArray);

                List<Integer> numbers = LottoGameUtil.StringArrayToList(inputArray);

                return new WinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING_ARRAY.getText());
            }
        }
    }

    private PurchaseAmount setPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.inputPurchaseAmount();
                InputValidator.validatePurchaseNumber(input);

                int number = LottoGameUtil.StringToInt(input);

                return new PurchaseAmount(number);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING.getText());
            }
        }
    }
}
