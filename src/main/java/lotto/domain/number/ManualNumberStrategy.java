package lotto.domain.number;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.StringUtils.convertToIntegerList;
import static lotto.utils.StringUtils.splitString;
import static lotto.utils.Validator.validatePositiveNumbers;

public class ManualNumberStrategy implements NumberStrategy {
    private final Lotto numbers;

    public ManualNumberStrategy(String numbers) {
        validate(numbers);
        this.numbers = new Lotto(validate(numbers));
    }

    @Override
    public Lotto generateNumber() {
        return numbers;
    }

    private List<Integer> validate(String numbers) {
        List<String> splitNumbers = splitString(numbers);
        List<Integer> convertedNumbers = convertToIntegerList(splitNumbers);

        validatePositiveNumbers(convertedNumbers);
        return convertedNumbers;
    }
}
