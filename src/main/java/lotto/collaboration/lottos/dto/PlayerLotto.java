package lotto.collaboration.lottos.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lotto.collaboration.lottos.Lotto;

public class PlayerLotto {

    private final List<Integer> numbers;

    public PlayerLotto(Lotto lotto) {
        this.numbers = lotto.stream().sorted().toList();
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
