package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public LottoResultMap getLottoResult(WinningNumbers winningNumbers) {
        Map<LottoResult, Integer> lottoResultCountMap = new HashMap<>();
        lottoList.stream().forEach(lotto -> {
            LottoResult lottoResult = lotto.getResult(winningNumbers);
            lottoResultCountMap.put(lottoResult, lottoResultCountMap.getOrDefault(lottoResult, 0) + 1);
        });
        return new LottoResultMap(lottoResultCountMap);
    }
}
