package lotto.stub;

import java.util.Arrays;
import java.util.List;
import lotto.service.generator.LottoNumberGenerator;

public class StubLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<Integer> DEFAULT_LOTTO_NUMBER = Arrays.asList(6, 2, 3, 4, 34, 5);

    @Override
    public List<Integer> generate() {
        return DEFAULT_LOTTO_NUMBER;
    }
}
