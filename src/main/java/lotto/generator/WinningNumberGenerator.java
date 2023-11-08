package lotto.generator;

import lotto.domain.model.WinningNumber;
import lotto.domain.validator.Validator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberGenerator {

    public WinningNumber run() {
        List<Integer> regularWinningNumbers = drawRegularWinningNumbers();

        try {
            WinningNumber winningNumber = new WinningNumber(regularWinningNumbers);

            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.run();
        }
    }

    private List<Integer> drawRegularWinningNumbers() {
        String inputValuesSeparatedByCommas = InputView.inputWinningNumbers();
        List<Integer> numbersInRange = new ArrayList<>();

        try {
            Validator.validateExistValue(inputValuesSeparatedByCommas);
            String[] splitByCommasValues = Validator.hasCommasWithoutSurroundingValues(inputValuesSeparatedByCommas);

            Validator.validateCountOfValues(splitByCommasValues);

            for (String val : splitByCommasValues) {
                int convertedNum = Validator.validateNumericInput(val.trim());
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

}
