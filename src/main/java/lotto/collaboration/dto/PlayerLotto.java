package lotto.collaboration.dto;

import static lotto.collaboration.dto.enums.PlayerLottoMessage.EXCEPTION_IS_NULL;
import static lotto.collaboration.dto.enums.PlayerLottoMessage.EXCEPTION_NOT_SIX;
import static lotto.collaboration.dto.enums.PlayerLottoMessage.EXCEPTION_OUT_OF_RANGE;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lotto.collaboration.Lotto;

public class PlayerLotto {

    private final List<Integer> numbers;

    public PlayerLotto(final Lotto lotto) {
        validate(lotto);
        this.numbers = lotto.stream().sorted().toList();
    }

    private void validate(Lotto lotto) {
        occurExceptionIfIsNull(lotto);
        occurExceptionIfNotSix(lotto);
        occurExceptionIfOutOfRange(lotto);
    }

    private static void occurExceptionIfIsNull(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException(EXCEPTION_IS_NULL.get());
        }
    }

    private static void occurExceptionIfNotSix(Lotto lotto) {
        if (lotto.stream().count() != 6) {
            throw new IllegalArgumentException(EXCEPTION_NOT_SIX.get());
        }
    }

    private static void occurExceptionIfOutOfRange(Lotto lotto) {
        if (lotto.stream().anyMatch(number -> number < 1 || 45 < number)) {
            throw new IllegalArgumentException(EXCEPTION_OUT_OF_RANGE.get());
        }
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerLotto that = (PlayerLotto) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
