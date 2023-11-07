package lotto.collaboration.lottos.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lotto.collaboration.lottos.Lotto;

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
            throw new IllegalArgumentException("초기화 되지 않은 로또 객체.");
        }
    }

    private static void occurExceptionIfNotSix(Lotto lotto) {
        if (lotto.stream().count() != 6) {
            throw new IllegalArgumentException("번호는 총 6개여야 합니다.");
        }
    }

    private static void occurExceptionIfOutOfRange(Lotto lotto) {
        if (lotto.stream().anyMatch(number -> number < 1 || 45 < number)) {
            throw new IllegalArgumentException("번호는 1부터 45까지의 숫자 중에서 선택할 수 있습니다.");
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
