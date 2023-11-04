package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("구매한 로또 목록에 대한 전체 당첨 결과를 생성할 수 있다.")
    @Test
    void createCompareResults() {
        // given
        Lotto lotto1 = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto2 = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        WinningLotto winningLotto = WinningLotto.createFrom(winningNumbers, bonusNumber);

        // when
        List<LottoRewardCondition> compareResults = lottos.createCompareResults(winningLotto);

        // then
        assertThat(compareResults).containsExactly(LottoRewardCondition.FIRST_WINNER,
                LottoRewardCondition.SECOND_WINNER);
    }
}