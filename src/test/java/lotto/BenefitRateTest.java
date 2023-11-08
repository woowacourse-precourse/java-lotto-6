package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BenefitRateTest {
    @DisplayName("수익률을 계산한다.")
    @Test
    void getBenefitTest() {
        RankResult rankResult = new RankResult();
        Lotto winnerLotto = new Lotto(List.of(1,2,3,10,11,12));
        Lotto fisrtLotto = new Lotto(List.of(1,2,3,10,44,45));
        Lotto secondLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lottos lottos = new Lottos(List.of(fisrtLotto, secondLotto));
        Money money = new Money(5000);
        int bonusNum = 7;
        UserLottoNum userLottoNum = new UserLottoNum(winnerLotto, bonusNum);
        rankResult.calcRankResult(userLottoNum, lottos);

        BenefitRate benefitRate = new BenefitRate(money, rankResult);

        assertThat(1100.0).isEqualTo(benefitRate.getBenefit());
    }
}
