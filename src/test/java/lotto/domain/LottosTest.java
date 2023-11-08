package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.constants.LottoReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("구매한 로또 목록에 대한 당첨 결과를 생성할 수 있다.")
    @Test
    void createCompareResults() {
        Lotto ticket1 = new Lotto(List.of(13, 22, 3, 24, 15, 7));
        Lotto ticket2 = new Lotto(List.of(13, 22, 3, 24, 15, 6));
        Lottos lottos = new Lottos(List.of(ticket1, ticket2));

        Lotto winningNumbers = new Lotto(List.of(13, 22, 3, 24, 15, 7));
        int bonusNumber = 6;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<LottoReward> compareResults = lottos.createCompareResults(winningLotto);
        assertThat(compareResults).containsAnyOf(LottoReward.FIRST_WINNER, LottoReward.SECOND_WINNER);
    }
}