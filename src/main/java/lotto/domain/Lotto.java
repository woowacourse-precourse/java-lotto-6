package lotto.domain;

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

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        Long count = numbers.stream()
            .filter(other::contains)
            .count();

        return count.intValue();
    }

    public int matchCount(int number) {
        Long count = numbers.stream()
            .filter(num -> num == number)
            .count();

        return count.intValue();
    }


    private LotteryResult makeLotteryResult(int matchCount, int bonusCount) {
        return LotteryResult.getWinnerMoneyOf(matchCount, bonusCount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<String> numberStrings = numbers.stream()
            .map(String::valueOf)
            .toList();
        sb.append("[");
        sb.append(String.join(",", numberStrings));
        sb.append("]");

        return sb.toString();
    }
}
