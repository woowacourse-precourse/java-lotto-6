package lotto.lotto;

import java.util.stream.Collectors;
import lotto.utils.StringSplitParser;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(String numbers) {
        this.lotto = splitStringToLotto(numbers);
    }

    private Lotto splitStringToLotto(String numbers) {
        return StringSplitParser.splitStringToNumbers(numbers).stream().map(Integer::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}
