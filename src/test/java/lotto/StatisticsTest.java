package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    @Test
    @DisplayName("bonusState가 존재하지 않는다면 matchNumber와 value가 일치한 enum 값이 반환되어야 한다.")
    void no_bonus() {
        int matchNumber = Statistics.FIVE_MATCHES.getValue();
        boolean bonusState = false;

        Assertions.assertThat(Statistics.of(matchNumber, bonusState)).isEqualTo(Statistics.FIVE_MATCHES);
    }

    @Test
    @DisplayName("bonusState가 존재한다면 matchNumber-1과 value가 일치한 enum 값이 반환되어야 한다.")
    void bonus() {
        int matchNumber = Statistics.SIX_MATCHES.getValue() + 1;
        boolean bonusState = true;

        Assertions.assertThat(Statistics.of(matchNumber, bonusState)).isEqualTo(Statistics.SIX_MATCHES);
    }

    @Test
    @DisplayName("bonusState가 존재하고 matchNumber가 6개이면 BONUS_MATCHES가 반환되어야 한다.")
    void bonus_with_five() {
        int matchNumber = 6;
        boolean bonusState = true;

        Assertions.assertThat(Statistics.of(matchNumber, bonusState)).isEqualTo(Statistics.BONUS_MATCHES);
    }

}