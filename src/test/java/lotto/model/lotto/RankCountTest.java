package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCountTest {
    private RankCount rankCount;

    @BeforeEach
    void setUp(){
        //given
        rankCount = new RankCount();
    }


    @DisplayName("해당 Rank 에 해당하는 count 1 증가 테스트")
    @Test
    void incrementRankCountTest(){
        //when
        rankCount.incrementCount(LottoRank.RANK1);
        //then
        assertThat(rankCount.getCounts(LottoRank.RANK1)).isEqualTo(1);
    }

    @DisplayName("해당 Rank 에 해당하는 count 여러 번 증가 테스트")
    @Test
    void incrementMultipleRankCountTest(){
        //when
        rankCount.incrementCount(LottoRank.RANK1);
        rankCount.incrementCount(LottoRank.RANK1);
        rankCount.incrementCount(LottoRank.RANK2);
        //then
        assertThat(rankCount.getCounts(LottoRank.RANK1)).isEqualTo(2);
        assertThat(rankCount.getCounts(LottoRank.RANK2)).isEqualTo(1);
    }
}
