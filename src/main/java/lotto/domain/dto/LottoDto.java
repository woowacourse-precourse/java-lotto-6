package lotto.domain.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoDto {
    private final List<Lotto> lottoData;

    public LottoDto(List<Lotto> lotties) {
        lottoData = lotties;
    }

    public List<Lotto> getData() {
        return Collections.unmodifiableList(lottoData);
    }
}
