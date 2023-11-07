package lotto;


import java.util.List;
import java.util.stream.Stream;

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

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
    public int matchNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContains)
                .count();
    }

    public int matchBonus(int bonus) {
        return (int) Stream.of(numbers.contains(bonus)).count();
    }

    public boolean isContains(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

}
