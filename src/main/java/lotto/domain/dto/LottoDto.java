package lotto.domain.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoDto {
    private final List<Lotto> lottiesData;
    private final int totalNumberOfLotto;

    public LottoDto(List<Lotto> lottiesData, int totalNumberOfLotto) {
        this.lottiesData = lottiesData;
        this.totalNumberOfLotto = totalNumberOfLotto;
    }

    public List<Lotto> getData() {
        return Collections.unmodifiableList(lottoData);
    }

    public int getTotalNumberOfLotto() {
        return totalNumberOfLotto;
    }
}
