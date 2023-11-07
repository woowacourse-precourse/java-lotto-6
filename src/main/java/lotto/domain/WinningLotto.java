package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    private final LottoValidator validator = new LottoValidator();
    private final Lotto winningLotto;

    public WinningLotto(String lotto) {
        List<Integer> numbers = createLottos(lotto);
        validator.validateNumbersRange(numbers);
        winningLotto = new Lotto(numbers);
    }

    private List<Integer> createLottos(String lotto) {
        return Stream.of(lotto.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
