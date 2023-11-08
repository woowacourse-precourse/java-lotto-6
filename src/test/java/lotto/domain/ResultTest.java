package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("로또 결과를 반환한다.")
    @Test
    void createResult() {
        List<LottoRanking> lottoRank = List.of(
                LottoRanking.FOURTH,
                LottoRanking.FIFTH,
                LottoRanking.SECOND,
                LottoRanking.FOURTH
        );

        Result result = new Result(lottoRank);
        Map<LottoRanking, Integer> expect = new EnumMap<>(LottoRanking.class) {{
            put(LottoRanking.FIRST, 0);
            put(LottoRanking.SECOND, 1);
            put(LottoRanking.THIRD, 0);
            put(LottoRanking.FOURTH, 2);
            put(LottoRanking.FIFTH, 1);
            put(LottoRanking.NO_MATCH, 0);
        }};

        assertEquals(expect, result.getLottoResult());
    }

    @DisplayName("총 상금을 계산한다.")
    @Test
    void createTotalPrize() {
        List<LottoRanking> lottoRank = List.of(
                LottoRanking.FOURTH,
                LottoRanking.FIFTH,
                LottoRanking.SECOND,
                LottoRanking.FOURTH
        );

        Result result = new Result(lottoRank);
        int expect = LottoRanking.FOURTH.getPrizeAmount() * 2
                + LottoRanking.FIFTH.getPrizeAmount()
                + LottoRanking.SECOND.getPrizeAmount();

        assertEquals(expect, result.calculateTotalPrize());
    }

}
