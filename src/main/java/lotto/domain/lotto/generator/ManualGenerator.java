package lotto.domain.lotto.generator;

import java.util.Arrays;
import java.util.List;

public class ManualGenerator extends LottoNumbersGenerator {
    @Override
    public List<Integer> generateLottoNumbers() {
        return Arrays.asList(6, 5, 3, 2, 4, 1);
    }
}
