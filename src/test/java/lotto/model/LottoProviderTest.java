package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

class LottoProviderTest {

    static final int WIN_FIRST_AND_FIFTH_MONEY = 2000005000;
    LottoProvider lottoProvider = new LottoProvider();
    List<LottoRank> lottoRanks = List.of(LottoRank.FIFTH,
            LottoRank.FIRST,
            LottoRank.NO
    );

    @Test
    void winningsPayments() {

        Assertions.assertEquals(lottoProvider.winningsPayments(lottoRanks), WIN_FIRST_AND_FIFTH_MONEY);
    }

    @Test
    void lottoHistory() {

        Map<String, Integer> lottoHistory = lottoProvider.lottoHistory(lottoRanks);

        List<Integer> testRank = List.of(1, 0, 0, 0, 1, 0);
        Assertions.assertEquals(lottoHistory.get("FIRST"), testRank.get(0));

    }
}