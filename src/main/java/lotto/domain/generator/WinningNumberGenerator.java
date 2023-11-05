package lotto.domain.generator;

import lotto.domain.model.WinningNumber;
import lotto.domain.validator.Validator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberGenerator {

    public WinningNumber run() {
        List<Integer> regularWinningNumbers = drawRegularWinningNumbers();
        int bonusNumber  = drawBonusNumber(new ArrayList<>(regularWinningNumbers));

        return new WinningNumber(regularWinningNumbers, bonusNumber);
    }

    private List<Integer> drawRegularWinningNumbers() {
        String inputValuesSeparatedByCommas = InputView.inputWinningNumbers();
        List<Integer> numbersInRange = new ArrayList<>();

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

            return numbersInRange;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.drawRegularWinningNumbers();
        }
    }

    private int drawBonusNumber(List<Integer> regularWinningNumbers) {
        String inputBonusValue = InputView.inputBonusNumber();

        try {
            Validator.validateExistValue(inputBonusValue);
            int convertedBonusNum = Validator.validateNumericInput(inputBonusValue);
            int bonusNumberInRange = Validator.validateNumberInRange(convertedBonusNum);

            regularWinningNumbers.add(bonusNumberInRange);
            Validator.validateDuplicateNumbers(regularWinningNumbers);

            return bonusNumberInRange;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.drawBonusNumber(regularWinningNumbers);
        }
    }
}
