package lotto.controller.util.handler;

import java.util.List;
import java.util.function.Supplier;
import lotto.controller.util.parser.InputParser;
import lotto.controller.util.validator.InputValidator;
import lotto.model.dto.BonusNumber;
import lotto.model.dto.PurchaseMoney;
import lotto.model.dto.WinningNumbers;
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

    public WinningNumbers getWinningNumbers() {
        return processInput(() -> {
            List<Integer> drawNumbers = inputParser.parseLottoNumbers(inputView.getWinningNumber());
            inputValidator.validateDrawNumbers(drawNumbers);
            return new WinningNumbers(drawNumbers);
        });
    }

    public BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        return processInput(() -> {
            Integer bonusNumber = inputParser.parseBonusNumber(inputView.getBonusNumber());
            inputValidator.validateBonusNumber(bonusNumber, winningNumbers.getNumbers());
            return new BonusNumber(bonusNumber);
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
