package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SaleLottoTest {
    @DisplayName("로또 등수 확인 테스트")
    @Test
    void checkLottoRankTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        SaleLotto saleLotto = new SaleLotto(numbers);
        WinningLotto winningLotto = new WinningLotto(numbers, 7);
        // when
        Rank rank = saleLotto.checkLottoRank(winningLotto);
        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}