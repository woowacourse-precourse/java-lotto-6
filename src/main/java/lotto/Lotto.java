package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Range.COUNT.content()) {
            throw new IllegalArgumentException(ExceptionList.LOTTOCOUNTEXCETION.content());
        } //로또 번호 개수 검사

        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException(ExceptionList.LOTTODUPLICATIONEXCEPTION.content());
        } //로또 번호 중복 검사

        if (!validateNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionList.LOTTORANGEEXCEPTION.content());
        } //로또 번호 범위 검사
    }

    private Boolean validateNumberRange(int number) {
        if (number < Range.START.content() || number > Range.END.content()) {
            return true;
        }
        return false;
    }

    private Boolean validateNumber(List<Integer> numbers) {
        for (int i : numbers) {
            if (validateNumberRange(i)) {
                return false;
            }
        }
        return true;
    }
}