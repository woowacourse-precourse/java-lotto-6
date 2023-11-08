package lotto.utility.vo.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;
import lotto.vo.response.WinningResponse;
import org.junit.jupiter.api.Test;

class WinningResponseTest {
    @Test
    void 당첨등수를_통계내어_올바른_출력형식으로_바꾼다() {
        // given
        List<Rank> 등수들 = 당첨_내역_생성하기();

        // when
        WinningResponse 당첨결과 = new WinningResponse(등수들);

        // then
        assertThat(당첨결과.createdMessage()).contains("4개 일치 (50,000원) - 1개", "5개 일치 (1,500,000원) - 2개");
    }

    private List<Rank> 당첨_내역_생성하기() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(등수_생성하기(5, false));
        ranks.add(등수_생성하기(5, false));
        ranks.add(등수_생성하기(4, false));
        return ranks;
    }

    private Rank 등수_생성하기(Integer 일치개수, boolean 보너스여부) {
        return Rank.determineByMatchingCount(일치개수, 보너스여부);
    }
}