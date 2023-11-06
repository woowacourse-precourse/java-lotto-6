package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.util.enums.LottoRank;

public class LottoResultRepository {
    private static final int DEFAULT = 0;

    private static List<LottoResult> lottoResults = new ArrayList<>();

    public static void add(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }

    public static void clear() {
        lottoResults.clear();
    }

    public static List<LottoRank> findLottoRankResults() {
        return findByIndex(DEFAULT).getRankResults();
    }

    private static LottoResult findByIndex(int index) {
        return lottoResults.get(index);
    }
}
