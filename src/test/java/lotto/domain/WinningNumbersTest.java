package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    @DisplayName("WinningNumbers와 Lotto 티켓을 비교하여 RankInfo 반환")
    void compareTo() {
        // Given
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        Lotto first = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = Lotto.of(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = Lotto.of(List.of(1, 2, 3, 4, 5, 45));
        Lotto fourth = Lotto.of(List.of(1, 2, 3, 4, 44, 45));
        Lotto fifth = Lotto.of(List.of(1, 2, 3, 43, 44, 45));
        Lotto none = Lotto.of(List.of(1, 2, 42, 43, 44, 45));

        WinningNumbers winning = new WinningNumbers(winningNumbers, BonusNumber.of(7));

        // When
        RankInfo rankFirst = winning.compareTo(first);
        RankInfo rankSecond = winning.compareTo(second);
        RankInfo rankThird = winning.compareTo(third);
        RankInfo rankFourth = winning.compareTo(fourth);
        RankInfo rankFifth = winning.compareTo(fifth);
        RankInfo rankNone = winning.compareTo(none);

        // Then
        assertThat(rankFirst).isEqualTo(RankInfo.FIRST);
        assertThat(rankSecond).isEqualTo(RankInfo.SECOND);
        assertThat(rankThird).isEqualTo(RankInfo.THIRD);
        assertThat(rankFourth).isEqualTo(RankInfo.FOURTH);
        assertThat(rankFifth).isEqualTo(RankInfo.FIFTH);
        assertThat(rankNone).isEqualTo(RankInfo.NONE);
    }

}