package lotto.domain;

import java.util.List;

public class LottoResult {
    private final int lottoCount;
    private final boolean isBonus;

    LottoResult(int lottoCount, boolean isBonus) {
        this.lottoCount = lottoCount;
        this.isBonus = isBonus;
    }
}
