package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 숫자를 입력해야 합니다.");
        }

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int count = 0;
        for (int number : numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }
    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}