package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumber(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public String getNumbersPrintFormat() {
        List<String> parsedNumbers = numbers.stream().map((number) -> Integer.toString(number)).toList();
        return "[" + String.join(", ", parsedNumbers) + "]";
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }
}
