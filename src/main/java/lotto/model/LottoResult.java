package lotto.model;

import java.util.List;
import lotto.enums.LottoStatus;

public class LottoResult {
    private final List<LottoStatus> lottoResult;

    public LottoResult(List<LottoStatus> lottoResult) {
        this.lottoResult = lottoResult;
    }

}
