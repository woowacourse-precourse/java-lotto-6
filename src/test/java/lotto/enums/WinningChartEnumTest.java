package lotto.enums;

import static lotto.enums.WinningChartEnum.FIVE_MATCH;
import static lotto.enums.WinningChartEnum.FIVE_AND_BONUS_MATCH;
import static lotto.enums.WinningChartEnum.THREE_MATCH;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningChartEnumTest {

    private static final Boolean BONUS = true;
    private static final Boolean NO_BONUS = false;
    @DisplayName("5개가 일치하고, bonus 가 참이면, FIVE_MATCH_PLUS_BONUS 가 된다.")
    @Test
    void valueOfWhen5CountBonus() {
        WinningChartEnum winningChartEnum = WinningChartEnum.valueOf(FIVE_MATCH.getMatchCount(), BONUS);
        String name = winningChartEnum.name();
        Assertions.assertThat(name).isEqualTo(FIVE_AND_BONUS_MATCH.name());
    }

    @DisplayName("5개가 일치하고, bonus 가 거짓이면, FIVE_MATCH 가 된다.")
    @Test
    void valueOfWhen5Count() {
        WinningChartEnum winningChartEnum = WinningChartEnum.valueOf(FIVE_MATCH.getMatchCount(), NO_BONUS);
        String name = winningChartEnum.name();
        Assertions.assertThat(name).isEqualTo(FIVE_MATCH.name());
    }

    @DisplayName("3개가 일치하고, bonus 가 거짓이면, THREE_MATCH 가 된다.")
    @Test
    void valueOfWhen3Count() {
        WinningChartEnum winningChartEnum = WinningChartEnum.valueOf(THREE_MATCH.getMatchCount(), NO_BONUS);
        String name = winningChartEnum.name();
        Assertions.assertThat(name).isEqualTo(THREE_MATCH.name());
    }

    @DisplayName("3개가 일치하고, bonus 가 참이어도, THREE_MATCH 가 된다.")
    @Test
    void valueOfWhen3CountButBonus() {
        WinningChartEnum winningChartEnum = WinningChartEnum.valueOf(THREE_MATCH.getMatchCount(), BONUS);
        String name = winningChartEnum.name();
        Assertions.assertThat(name).isEqualTo(THREE_MATCH.name());
    }
}