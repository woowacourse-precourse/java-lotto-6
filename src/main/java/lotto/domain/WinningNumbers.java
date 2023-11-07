package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.utils.IntegerConverter;

public class WinningNumbers {
    public static final String DELIMITER = ",";

    private final Lotto winningLotto;

    public WinningNumbers(String value) {
        List<Integer> numbers = mapToLottoNumbers(value);
        this.winningLotto = new Lotto(numbers);
    }

    public List<Integer> mapToLottoNumbers(String value) {
        return Arrays.stream(value.split(DELIMITER))
                .map(IntegerConverter::convert)
                .toList();
    }

    public boolean isContain(LottoNumber number) {
        return winningLotto.isContain(number);
    }
}
