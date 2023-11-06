package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto copyOf(Lotto lotto) {
        return new Lotto(lotto.getNumbers());
    }

    public static Lotto createLotto(LottoRandom random){
        return new Lotto(random.generateNumbers());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int matches(List<Integer> otherNumbers){
        return (int) numbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
