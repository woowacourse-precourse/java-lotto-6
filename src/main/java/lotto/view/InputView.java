package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.exception.DuplicateInputException;
import lotto.exception.HasNotCommaException;
import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.InputConstants.SPLIT_STANDARD;

public class InputView {

    private final InputValidator inputValidator;
    private final OutputView outputView;

    public InputView() {
        inputValidator = new InputValidator();
        outputView = new OutputView();
    }

    public Long purchaseLotto() {
        while (true) {
            String inputMoney = getInput();
            try {
                validateInputMoney(inputMoney);
                return convertInputToLong(inputMoney);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 초과하는 금액 입리");
            }
        }
    }

    private Long convertInputToLong(String inputMoney) {
        return Long.parseLong(inputMoney);
    }

    private void validateInputMoney(String inputMoney) {
        inputValidator.validateInputMoney(inputMoney);
    }


    public List<Integer> inputWinningNumbers() {
        while (true) {
            String inputWinningNumbers = getInput();
            try {
                inputValidator.validateInputWinningNumbersHasComma(inputWinningNumbers);
                List<Integer> winningNumbers = convertInputToList(inputWinningNumbers);

                return winningNumbers;
            } catch (DuplicateInputException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (HasNotCommaException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private String getInput() {
        return Console.readLine();
    }

    private List<Integer> convertInputToList(String inputWinningNumbers) {
        List<Integer> convertWinningNumbers = Arrays.stream(inputWinningNumbers.split(SPLIT_STANDARD))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        inputValidator.validateConvertInputToList(convertWinningNumbers);

        return convertWinningNumbers;
    }

    public BonusNumber inputBonusNumber() {
        while (true) {
            String bonusNumber = getInput();
            try {
                return convertInputToBonusNumber(bonusNumber);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber convertInputToBonusNumber(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }
}
