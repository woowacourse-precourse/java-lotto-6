package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::containNumber).count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overlapCheck.add(numbers.get(i));
        }
        if (overlapCheck.size() != 6) {
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }


}
