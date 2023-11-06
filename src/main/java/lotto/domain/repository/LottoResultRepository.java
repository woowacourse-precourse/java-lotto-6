package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.util.enums.LottoRank;

public class LottoResultRepository {
    private static List<LottoRank> lottoResults = new ArrayList<>();

    public static List<LottoRank> lottoResults() {
        return lottoResults;
    }

    public static void add(LottoRank lottoRank) {
        lottoResults.add(lottoRank);
    }
}
