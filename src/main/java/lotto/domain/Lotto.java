package lotto.domain;

import java.util.List;

//로또 번호를 나타내는 클래스
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(Lotto other) {
        long matchCount = numbers.stream()
                .filter(other.numbers::contains)
                .count();
        return (int) matchCount;
    } // 몇 개의 번호가 일치하는지를 게산

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || !isWithinRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

}
