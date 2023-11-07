package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultManagerTest {
    private LottoResultManager lottoResultManager;

    @BeforeEach
    void setUp() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIRST);
        ranks.add(Rank.SECOND);
        lottoResultManager = new LottoResultManager(ranks);
    }

    @Test
    void 최종_상금() {
        int expect = Rank.FIRST.getPrizeMoney() + Rank.SECOND.getPrizeMoney();
        //2030000000 예상
        int result = lottoResultManager.getTotalPrize();
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 최종_랭킹이_담겨있는_Map_반환() {
        Map<Rank, Integer> expect = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            expect.put(rank, 0);
        }
        expect.put(Rank.FIRST, 1);
        expect.put(Rank.SECOND, 1);
        expect.remove(Rank.NOTHING);

        Map<Rank, Integer> result = lottoResultManager.getLottoResult();
        assertThat(result).isEqualTo(expect);
    }

}