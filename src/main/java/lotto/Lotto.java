package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> generateLotteryNumbers() {
        List<Integer> lotteryNumbers = new ArrayList<>();
        List<Integer> numbersInRange = Randoms.
                pickUniqueNumbersInRange(1, 45, 6);
        lotteryNumbers.addAll(numbersInRange);
        return lotteryNumbers;
    }

    public static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
