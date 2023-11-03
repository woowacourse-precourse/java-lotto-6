package lotto;

import java.util.List;

public class LottoResult {

    private final LottoComparator comparator = new LottoComparator();

    public LottoResult() {
    }

    public void showLottoResult(List<String> winningNumbers, Integer bonus, List<Lotto> lottos) {
        comparator.compareLotto();
    }
}
