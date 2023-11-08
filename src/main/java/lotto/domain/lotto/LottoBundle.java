package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.LottoBundleDto;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle() {
        this.lottoBundle = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoBundle.add(lotto);
    }

    public LottoBundleDto makeLottoBundleDto() {
        return new LottoBundleDto(lottoBundle, lottoBundle.size());
    }
}
