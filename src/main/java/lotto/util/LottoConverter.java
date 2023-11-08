package lotto.util;

import java.util.Arrays;
import lotto.Lotto;

public class LottoConverter {
    public static Lotto convertStringToLotto(String winningLottoNumbers) {
        return new Lotto(Arrays.stream(winningLottoNumbers.split(","))
                .map(Integer::parseInt)
                .toList());
    }
}
