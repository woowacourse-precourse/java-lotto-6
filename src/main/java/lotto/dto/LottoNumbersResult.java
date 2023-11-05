package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public class LottoNumbersResult {
    private final Lotto lotto;

    public LottoNumbersResult(Lotto lotto) {
        this.lotto = lotto;
    }

    public String getFormattedLottoNumbers() {
        List<Integer> lottoNumbers = lotto.getLotto();
        return lottoNumbers.toString();
    }
}
