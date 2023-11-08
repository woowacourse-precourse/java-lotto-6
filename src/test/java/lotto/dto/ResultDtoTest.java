package lotto.dto;

import lotto.util.consts.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ResultDtoTest {

    HashMap<Ranking, Integer> rankingCounts;
    double benefitRate;

    @BeforeEach
    void 데이터_세팅() {
        rankingCounts = new HashMap<>();
        rankingCounts.put(Ranking.FIRST, 1);
        rankingCounts.put(Ranking.SECOND, 2);
        benefitRate = 30.0;
    }

    @Test
    void 레코드는_생성자_기능을_갖고_있다() {
        ResultDto resultDto = new ResultDto(rankingCounts, benefitRate);
        assertThat(resultDto).isEqualTo(new ResultDto(rankingCounts, benefitRate));
    }

    @Test
    void rankingCounts는_각_순위별로_몇_번_했는지를_포함한다() {
        ResultDto resultDto = new ResultDto(rankingCounts, benefitRate);
        assertThat(resultDto.rankingCounts()).isEqualTo(rankingCounts);
        assertThat(resultDto.rankingCounts().get(Ranking.FIRST))
                .isEqualTo(1);
        assertThat(resultDto.rankingCounts().get(Ranking.SECOND))
                .isEqualTo(2);
    }

    @Test
    void benefitRate는_수익률이_어느정도였는지를_저장한다() {
        ResultDto resultDto = new ResultDto(rankingCounts, benefitRate);
        assertThat(resultDto.benefitRate()).isEqualTo(30.0);
    }
}