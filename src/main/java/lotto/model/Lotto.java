package lotto.model;

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
        checkDuplicated(numbers);
    }

    private void checkDuplicated(List<Integer> numbers) {
        boolean[] added = new boolean[46];
        for (int lotteryNumber : numbers) {
            if (1 > lotteryNumber || lotteryNumber > 45 || added[lotteryNumber]) {
                throw new IllegalArgumentException("입력한 로또 번호들이 잘못되었습니다.");
            }
            added[lotteryNumber] = true;
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
