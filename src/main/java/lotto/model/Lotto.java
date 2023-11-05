package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || invalidRange(numbers) || isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int[] getScore(final List<Integer> winningNumbers, final int bonusNumber) {
        int[] score = new int[2];
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                score[0]++;
            }
        }
        if (score[0] == 5 && numbers.contains(bonusNumber)) {
            score[1]++;
        }
        return score;
    }

    private boolean invalidRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i > 45 || i < 1) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (numbers.lastIndexOf(number) != i) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
