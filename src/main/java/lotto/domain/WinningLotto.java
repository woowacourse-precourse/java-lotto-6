package lotto.domain;

import java.util.List;
import lotto.utils.StringUtils;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(String numbers) {
        this.numbers = StringUtils.split(numbers);
    }
}
