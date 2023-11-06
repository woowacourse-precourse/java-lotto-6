package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DuplicateInputException;
import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.constants.InputConstants.SPLIT_STANDARD;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public Integer purchaseLotto() {
        while (true) {
            String inputMoney = getInput();
            try {
                validateInputMoney(inputMoney);
                return convertInputToInteger(inputMoney);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer convertInputToInteger(String inputMoney) {
        return Integer.parseInt(inputMoney);
    }

    private void validateInputMoney(String inputMoney) {
        inputValidator.validateInputMoney(inputMoney);
    }


    public List<Integer> inputWinningNumbers() {
        while (true) {
            String inputWinningNumbers = getInput();
            try {
                List<Integer> winningNumbers = convertInputToList(inputWinningNumbers);
                return winningNumbers;
            } catch (DuplicateInputException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInput() {
        return Console.readLine();
    }

    private List<Integer> convertInputToList(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(SPLIT_STANDARD))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer inputBonusNumber() {
        while (true) {
            String bonusNumber = getInput();
            try {
                validateBonusNumber(bonusNumber);
                return convertInputToInteger(bonusNumber);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        inputValidator.validateBonusNumber(bonusNumber);
    }
}
