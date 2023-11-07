package lotto.lottoGame;

import static lotto.validation.LottoValidation.validateNatureValue;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoInputGenerator {
    public Lotto inputNumbersToLotto(String inputWinningNumbers) {
        String[] parsedNumbers = inputWinningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : parsedNumbers) {
            possibleAddNumbers(number, numbers);
        }

        numbers.sort((o1, o2) -> o1 - o2);
        return new Lotto(numbers);
    }

    private void possibleAddNumbers(String number, List<Integer> numbers) {
        validateNatureValue(number);
        numbers.add(Integer.parseInt(number));
    }

    public int inputBonusToValidatedValue(String inputBonusNumber) {
        validateNatureValue(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }
}
