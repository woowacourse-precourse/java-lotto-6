package lotto.app.collaboration;

import static lotto.app.collaboration.enums.LottoMessage.COUNT_OF_NUMBERS;
import static lotto.app.collaboration.enums.LottoMessage.EXCEPTION_DUPLICATED;
import static lotto.app.collaboration.enums.LottoMessage.EXCEPTION_NOT_SIX;
import static lotto.app.collaboration.enums.LottoMessage.EXCEPTION_OUT_OF_RANGE;
import static lotto.app.collaboration.enums.LottoMessage.MAX_NUMBER_RANGE;
import static lotto.app.collaboration.enums.LottoMessage.MIN_NUMBER_RANGE;

import java.util.List;
import java.util.stream.Stream;
import lotto.app.game.io.Randoms;

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
        if (numbers.stream().anyMatch(number ->
                number < MIN_NUMBER_RANGE || MAX_NUMBER_RANGE < number)) {
            throw new IllegalArgumentException(EXCEPTION_OUT_OF_RANGE.get());
        }
    }

    private void occurExceptionIfNotSix(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException(EXCEPTION_NOT_SIX.get());
        }
    }

    private void occurExceptionIfDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATED.get());
        }
    }

    public static Lotto make(final Randoms randoms) {
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
