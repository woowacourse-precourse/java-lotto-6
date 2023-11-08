package lotto.domain;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
}