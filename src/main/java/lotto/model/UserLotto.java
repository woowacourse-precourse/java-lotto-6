package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private List<Lotto> lottos;

    public UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoResult> calculateResult(WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();
        lottos.forEach(lotto -> {
            lottoResults.add(lotto.calculateResult(winningLotto));
        });
        return lottoResults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.toString()).append("\n"));
        return sb.toString();
    }
}
