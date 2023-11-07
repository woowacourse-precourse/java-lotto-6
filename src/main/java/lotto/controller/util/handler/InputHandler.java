package lotto.controller.util.handler;

import java.util.List;
import java.util.function.Supplier;
import lotto.controller.util.parser.InputParser;
import lotto.controller.util.validator.InputValidator;
import lotto.model.dto.PurchaseMoney;
import lotto.model.dto.WinningNumber;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class InputHandler {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final InputValidator inputValidator;

    public InputHandler(InputView inputView, OutputView outputView, InputParser inputParser,
                        InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }

    public PurchaseMoney getPurchaseMoney() {
        return processInput(() -> {
            Integer moneyAmount = inputParser.parseMoney(inputView.getMoney());
            inputValidator.validateMoney(moneyAmount);
            return new PurchaseMoney(moneyAmount);
        });
    }

    public WinningNumber getWinningNumber() {
        List<Integer> drawNumbers = getDrawNumbers();
        Integer bonusNumber = getBonusNumber(drawNumbers);

        return new WinningNumber(drawNumbers, bonusNumber);
    }

    private List<Integer> getDrawNumbers() {
        return processInput(() -> {
            List<Integer> drawNumbers = inputParser.parseLottoNumbers(inputView.getWinningNumber());
            inputValidator.validateDrawNumbers(drawNumbers);
            return drawNumbers;
        });
    }

    private Integer getBonusNumber(List<Integer> drawNumbers) {
        return processInput(() -> {
            Integer bonusNumber = inputParser.parseBonusNumber(inputView.getBonusNumber());
            inputValidator.validateBonusNumber(bonusNumber, drawNumbers);
            return bonusNumber;
        });
    }

    private <T> T processInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
