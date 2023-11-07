package lotto.collaboration;

import java.util.List;
import java.util.stream.Stream;
import lotto.game.io.Randoms;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        occurExceptionIfOutOfRange(numbers);
        occurExceptionIfNotSix(numbers);
        occurExceptionIfDuplicated(numbers);
    }

    private void occurExceptionIfOutOfRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || 45 < number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자 중에서 선택할 수 있습니다");
        }
    }

    private void occurExceptionIfNotSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void occurExceptionIfDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public static Lotto make(Randoms randoms) {
        return new Lotto(randoms.getSixNumbers());
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
