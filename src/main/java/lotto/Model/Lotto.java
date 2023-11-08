package lotto.Model;

import static lotto.Global.Constants.LOTTO_NUMBER_AMOUNT;
import static lotto.Global.Constants.LOTTO_NUMBER_MAX_RANGE;
import static lotto.Global.Constants.LOTTO_NUMBER_MIN_RANGE;

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
        if (!isNumbersSizeValidate(numbers)) {
            throw new IllegalArgumentException(Exception.LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase());
        }
        if (!isNumbersRangeValidate(numbers)) {
            throw new IllegalArgumentException(Exception.LOTTO_WRONG_AMOUNT_INPUT.getErrorPhrase());
        }
        if (!isUniqueNumberValidate(numbers)) {
            throw new IllegalArgumentException(Exception.LOTTO_NO_DUPLICATE_CREATE.getErrorPhrase());
        }
    }

    private Boolean isNumbersRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
                return false;
            }
        }
        return true;
    }

    private Boolean isNumbersSizeValidate(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_AMOUNT;
    }

    private Boolean isUniqueNumberValidate(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    public String getLottoCreatedResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[]");
        String result = numbers.stream().map(Object::toString).collect(Collectors.joining(", "));
        stringBuilder.insert(1, result);
        return stringBuilder.toString();
    }

    public int matchesNumberList(Lotto lotto) {
        return numbers.stream().filter(lotto.numbers::contains).collect(Collectors.toList()).size();
    }

    public int matchesSingleNumber(int inputNumber) {
        if (numbers.contains(inputNumber)) {
            return 1;
        }
        return 0;
    }

}
