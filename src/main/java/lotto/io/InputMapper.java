package lotto.io;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Amount;
import lotto.domain.Lotto;

public class InputMapper {

    private static final String DELIMITER = ",";

    public Amount toAmount(final String input) {
        return new Amount(Integer.parseInt(input));
    }

    public Lotto toWinningLotto(final String input) {
        List<Integer> numbers = Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }
}
