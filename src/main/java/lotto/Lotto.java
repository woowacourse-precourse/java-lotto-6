package lotto;

import java.util.Collections;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumber() {
        System.out.println(numbers);
    }

    public int calcMatch(List<Integer> targetNumbers, int bonusNumber) {
        int count = 0;
        int bonus = 0
        for (int i = 0; i < 6; i++) {
            if (targetNumbers.get(i) == numbers.get(i)) {
                count++;
            }
            if (bonusNumber == numbers.get(i)) {
                bonus = 1;
            }
        }
        return matchToPrize(count, bonus)
    }

    private int matchToPrize(int count, int bonus) {
        if (count == 6) {
            return 1;
        }
        if (count == 5 && bonus == 1) {
            return 2;
        }
        if (count == 5) {
            return 3;
        }
        if (count == 4) {
            return 4;
        }
        if (count == 3) {
            return 5;
        }
    }
}
