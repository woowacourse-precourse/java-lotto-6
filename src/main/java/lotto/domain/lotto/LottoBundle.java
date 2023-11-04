package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.lottoresult.LottoResult;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle() {
        this.lottoBundle = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoBundle.add(lotto);
    }

    public List<LottoResult> getLottoResults(WinLotto winLotto) {
        return lottoBundle.stream()
                .map(winLotto::getLottoResult)
                .collect(Collectors.toList());
    }

    public LottoBundleDto makeLottoBundleDto() {
        return new LottoBundleDto(lottoBundle, lottoBundle.size());
    }
}
