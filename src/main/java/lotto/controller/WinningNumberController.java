package lotto.controller;

import lotto.constant.WinningNumberConstant;
import lotto.domain.model.WinningNumber;
import lotto.domain.validator.Validator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningNumberController {

    public WinningNumber drawWinningNumbers() {
        String inputValuesSeparatedByCommas = InputView.inputWinningNumbers();
        List<Integer> numbersInRange = new ArrayList<>();
        HashMap<Integer, String> regularWinningNumbers = new HashMap<>();

        try {
            Validator.validateExistValue(inputValuesSeparatedByCommas);
            String[] splitByCommasValues = Validator.hasCommasWithoutSurroundingValues(inputValuesSeparatedByCommas);

            Validator.validateCountOfValues(splitByCommasValues);

            for (String val : splitByCommasValues) {
                int convertedNum = Validator.validateNumericInput(val);
                int numberInRange = Validator.validateNumberInRange(convertedNum);
                numbersInRange.add(numberInRange);
            }

            Validator.validateDuplicateNumbers(numbersInRange);

            for (int number : numbersInRange) {
                regularWinningNumbers.put(number, WinningNumberConstant.REGULAR);
            }

            return new WinningNumber(regularWinningNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.drawWinningNumbers();
        }
    }
}
