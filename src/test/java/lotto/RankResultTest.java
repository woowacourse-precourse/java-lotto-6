package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankResultTest {
    @DisplayName("일치한 등수의 개수를 반환한다.")
    @Test
    void getRankResultTest() {
        RankResult rankResult = new RankResult();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNum = 7;
        UserLottoNum userLottoNum = new UserLottoNum(lotto, bonusNum);

        rankResult.calcRankResult(userLottoNum, lottos);

        assertThat(1).isEqualTo(rankResult.getRankResultCnt(Rank.FIRST));
    }
}
