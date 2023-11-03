package lotto.dto.output;

import java.util.List;
import lotto.domain.lotto.Lotto;

public record LottoDto(List<Integer> lottoNumbers) {
    public static LottoDto toLottoDto(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
