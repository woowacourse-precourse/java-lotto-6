package lotto.domain.utils;

import java.util.List;
import lotto.domain.LottoRandom;

public class FixedRandom implements LottoRandom {
    @Override
    public List<Integer> generateNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
