package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.WinningStatistics.calculateWinningConditions;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinningStatisticsTest {
    @Test
    @DisplayName("각기 다른 당첨 번호와 보너스 번호가 주어질 경우 로또 번호들과 비교하여 당첨 통계를 리턴")
    void testCalculateWinningConditions() {
        // given
        int cnt = 23;
        UserLotto userLotto = mock(UserLotto.class);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumbers bonusNumbers = new BonusNumbers(List.of(7));

        // when
        when(userLotto.getLottoTickets()).thenReturn(List.of(
                new Lotto(List.of(7,8,9,10,11,12)),
                new Lotto(List.of(1,7,8,9,10,11)),
                new Lotto(List.of(1,2,7,8,9,10)),
                new Lotto(List.of(1,2,3,7,8,9)),
                new Lotto(List.of(1,2,3,7,8,9)),
                new Lotto(List.of(1,2,3,4,8,9)),
                new Lotto(List.of(1,2,3,4,8,9)),
                new Lotto(List.of(1,2,3,4,8,9)),
                new Lotto(List.of(1,2,3,4,5,9)),
                new Lotto(List.of(1,2,3,4,5,9)),
                new Lotto(List.of(1,2,3,4,5,9)),
                new Lotto(List.of(1,2,3,4,5,9)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6))
                )
        );
        WinningStatistics result = calculateWinningConditions(userLotto, winningNumbers, bonusNumbers);

        // then
        Assertions.assertThat(result.getStatistics()).usingRecursiveComparison().isEqualTo(List.of(2,3,4,5,6));
    }
}