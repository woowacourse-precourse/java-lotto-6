package lotto.util;

import java.util.Arrays;

public class ManualGenerator extends LottoNumbersGenerator {
    @Override
    protected void generateLottoNumbers() {
        numbers = Arrays.asList(6, 5, 3, 2, 4, 1);
    }
}
