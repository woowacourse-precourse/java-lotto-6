package lotto.Model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Global.Exception;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase());
        }
    }

    public String getLottoCreatedResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[]");
        String result = numbers.stream().map(Object::toString).collect(Collectors.joining(","));
        stringBuilder.insert(1, result);
        return stringBuilder.toString();
    }

    public int matchesNumberList(List<Integer> inputNumber) {
        return numbers.stream().filter(inputNumber::contains).collect(Collectors.toList()).size();
    }

    public int matchesSingleNumber(int inputNumber) {
        if (numbers.contains(inputNumber)) {
            return 1;
        }
        return 0;
    }

    // TODO: 추가 기능 구현
}
