package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto, int bonus) {
        int count = 0;
        boolean isBonus = false;
        for (int num: this.numbers) {
            if (winningLotto.numbers.contains(num)){
                count++;
            }
        }
        if (count == 5 && this.numbers.contains(bonus)) {
            isBonus = true;
        }
        return Statistic.getRank(count, isBonus);
    }
}
