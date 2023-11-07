package lotto.domain;

import java.util.ArrayList;
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

    public int countMatchNumbers(List<Integer> matchTarget) {
        return (int) numbers.stream().filter(matchTarget::contains).count();
    }

    protected List<Integer> getUnmodifiableNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(numbers));
    }
}
