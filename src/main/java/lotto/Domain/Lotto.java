package lotto.Domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.Domain.Validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.doValidate(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean hasNumber(int num) {
        return numbers.contains(num);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    @Override
    public String toString() {
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        return sortedNumbers.toString().replaceAll(" ","");
    }
}
