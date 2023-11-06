package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcher {
    List<Lotto> lottos;

    public LottoMatcher(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public GroupedLottoMatchResult matchAll(List<Integer> winning, int bonus) {
        List<LottoMatchResult> result = new ArrayList<>();
        for (var lotto : lottos) {
            result.add(lotto.match(winning, bonus));
        }
        return new GroupedLottoMatchResult(result);
    }

    public long totalLottoCount() {
        return lottos.size();
    }
}
