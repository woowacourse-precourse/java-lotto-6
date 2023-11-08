package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int countMatchNumber(WinnigNumber winnigNumber) {
        return (int) numbers.stream()
                .filter(winnigNumber::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    //자동 생성된 로또를 형식에 맞춰 출력
    public StringBuilder numbersWithForm() {
        Collections.sort(numbers);
        StringBuilder result = new StringBuilder(OutputView.FRONT_BRACKETS);
        for (Integer number : numbers) {
            result.append(number).append(OutputView.COMMAS).append(" ");
        }
        result.delete(result.length() - 2, result.length()).append(OutputView.REAR_BRACKETS);
        return result;
    }

    public void validate() {
        validateNumberOfNumber(numbers);
    }

    private void validateNumberOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}

