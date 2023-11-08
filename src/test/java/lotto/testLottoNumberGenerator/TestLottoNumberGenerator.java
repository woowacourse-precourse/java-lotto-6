package lotto.testLottoNumberGenerator;

import lotto.LottoNumberGenerator.LottoGenerator;

import java.util.List;

public class TestLottoNumberGenerator implements LottoGenerator {
    @Override
    public List<Integer> pickLottoNumber() {
        return List.of(1,2,3,4,5,6);
    }
}
