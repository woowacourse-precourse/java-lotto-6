package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.MatchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final LottoService lottoService = new LottoServiceImpl();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 통계 계산하는 테스트")
    @Test
    void test() {

        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 45)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));
        lottos.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int bonusNumber = 45;

        // when
        Map<MatchType, Integer> winningStatistics =
                lottoService.calculateWinningStatistics(lottos,
                        winningNumbers,
                        bonusNumber);

        // then
        assertThat(winningStatistics.get(MatchType.THREE)).isEqualTo(1);
        assertThat(winningStatistics.get(MatchType.FOUR)).isEqualTo(1);
        assertThat(winningStatistics.get(MatchType.FIVE)).isEqualTo(1);
        assertThat(winningStatistics.get(MatchType.FIVE_BONUS)).isEqualTo(1);
        assertThat(winningStatistics.get(MatchType.SIX)).isEqualTo(1);
    }
}