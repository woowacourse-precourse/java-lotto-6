package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public record LottoResult(List<Integer> lottoNumbers) {

    public static LottoResult from(Lotto lotto) {
        return new LottoResult(lotto.getNumbers());
    }
}
