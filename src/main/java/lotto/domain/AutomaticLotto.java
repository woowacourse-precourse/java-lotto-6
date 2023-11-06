package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutomaticLotto extends Lotto {

    public AutomaticLotto() {
        super();
    }

    public static List<AutomaticLotto> from(final Integer ticket) {
        return IntStream.range(0, ticket)
                .mapToObj(idx -> new AutomaticLotto())
                .collect(Collectors.toList());
    }

    public List<Integer> getAutomaticLottoNumbers() {
        return this.getNumbers();
    }
}
