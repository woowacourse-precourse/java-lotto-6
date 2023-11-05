package lotto;

import java.util.List;

public class Lotto {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;
    private final boolean[] visitNumber = new boolean[MAXIMUM_LOTTO_NUMBER + 1];

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        numbers.forEach(this::validateRangeNumber);
        duplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 개수는 6개 입니다.");
        }
    }


    private void duplicatedNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (visitNumber[number]) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자입니다.");
            }
            visitNumber[number] = true;
        }
    }

    public void validateRangeNumber(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
        }
    }


    public void containNumber(int bonusNumber) {
        if (visitNumber[bonusNumber]) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 똑같은 숫자입니다.");
        }
    }
}
