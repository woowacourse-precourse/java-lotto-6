package lotto.util;

import java.util.Arrays;
import lotto.model.Lotto;

public class LottoConverter {
    private LottoConverter() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static Lotto convertStringToLotto(String winningLottoNumbers) {
        return new Lotto(Arrays.stream(winningLottoNumbers.split(","))
                .map(Integer::parseInt)
                .toList());
    }
}
