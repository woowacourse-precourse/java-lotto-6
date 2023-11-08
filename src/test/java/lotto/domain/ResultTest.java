package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("로또 결과를 반환한다.")
    @Test
    void createResult() {
        List<LottoRanking> lottoRank = new ArrayList<>();
        lottoRank.add(LottoRanking.valueOf(4, false));
        lottoRank.add(LottoRanking.valueOf(3, false));
        lottoRank.add(LottoRanking.valueOf(5, true));
        lottoRank.add(LottoRanking.valueOf(4, false));

        Result result = new Result(lottoRank);
        Map<LottoRanking, Integer> expect = new EnumMap<>(LottoRanking.class) {{
            put(LottoRanking.valueOf(6, false), 0);
            put(LottoRanking.valueOf(5, true), 1);
            put(LottoRanking.valueOf(5, false), 0);
            put(LottoRanking.valueOf(4, false), 2);
            put(LottoRanking.valueOf(3, false), 1);
            put(LottoRanking.valueOf(0, false), 0);
        }};

        assertEquals(expect, result.getLottoResult());
    }
}
