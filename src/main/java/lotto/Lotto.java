package lotto;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.");
        }

        HashSet<Integer> nums = new HashSet<>();

        for (int num: numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 숫자를 입력하세요.");
            } else if (nums.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 중복될 수 없습니다.");
            }
            nums.add(num);
        }
    }

    public int calculate(List<Integer> input) {
        int score = 0;

        for (int num: this.numbers) {
            if (input.contains(num)) {
                score++;
            }
        }

        return score;
    }
}
