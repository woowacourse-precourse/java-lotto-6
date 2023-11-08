package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("LottoResult는 올바른 Rank의 갯수를 저장한다")
    @Test
    void storeCorrectNumberOfRanks() {
        List<Rank> ranks = List.of(
            Rank.FIRST, Rank.FIRST, Rank.FIRST,
            Rank.SECOND, Rank.FOURTH, Rank.FOURTH, Rank.FIFTH);

        ranks.forEach(rank -> lottoResult.addRank(rank));

        assertThat(lottoResult.getNumberOfRankByMap()).contains(
            entry(Rank.FIRST, 3),
            entry(Rank.SECOND, 1),
            entry(Rank.THIRD, 0),
            entry(Rank.FOURTH, 2),
            entry(Rank.FIFTH, 1),
            entry(Rank.MISS, 0)
        );
    }
}