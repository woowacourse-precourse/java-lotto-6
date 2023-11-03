package lotto.domain.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoBundleDto {
    private final List<Lotto> lottoBundle;
    private final int totalNumberOfLotto;

    public LottoBundleDto(List<Lotto> lottoBundle, int totalNumberOfLotto) {
        this.lottoBundle = lottoBundle;
        this.totalNumberOfLotto = totalNumberOfLotto;
    }

    public List<Lotto> getLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }

    public int getTotalNumberOfLotto() {
        return totalNumberOfLotto;
    }
}
