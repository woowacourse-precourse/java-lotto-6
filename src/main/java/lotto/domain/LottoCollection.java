package lotto.domain;

import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoCollection;

    public LottoCollection(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    public static LottoCollection from(List<Lotto> lottos) {
        return new LottoCollection(lottos);
    }

    public List<Lotto> getLottoCollection() {
        return lottoCollection;
    }

    public List<LottoResult> getResultGroup(Lotto winningLotto, int bonusNumber) {
        return lottoCollection.stream()
                .map(lotto -> lotto.getResult(winningLotto, bonusNumber))
                .toList();
    }

    public void setResultGroup(Lotto winningLotto, int bonusNumber) {
        List<LottoResult> resultGroup = getResultGroup(winningLotto, bonusNumber);
        for (LottoResult lottoResult:resultGroup) {
            lottoResult.setResult();
        }
    }
}
