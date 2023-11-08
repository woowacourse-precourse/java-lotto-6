package lotto.constants;

import static lotto.constants.Message.NEW_LINE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class WinningTypeTest {
    @ParameterizedTest
    @DisplayName("당첨(중복)된 숫자에 따라 알맞은 WinningType을 반환한다.")
    @CsvSource({"3, false, THREE",
            "4, false, FOUR",
            "5, false, FIVE",
            "5, true, FIVE_BONUS",
            "6, false, SIX",
            "2, false, NONE"})
    public void should_properWinningType_when_matchedCountPassed(int matchedCount, boolean isBonus,
                                                                 WinningType winningType) {
        //when
        WinningType result = WinningType.findTypeByCount(matchedCount, isBonus);

        //then
        assertThat(result).isEqualTo(winningType);
    }

    @ParameterizedTest
    @DisplayName("WinningType의 Type이 NONE이 아닌 경우, NEW_LINE을 포함하여 반환한다.")
    @EnumSource(value = WinningType.class, names = {"THREE", "FOUR", "FIVE", "FIVE_BONUS", "SIX"})
    public void should_returnDifferentResult_By_winningType(WinningType winningType) {
        String message = winningType.getMessage();
        assertThat(message).contains(NEW_LINE.getMessage());
    }

    @Test
    @DisplayName("WinningType이 NONE인 경우, NEW_LINE을 포함하지 않고 반환한다.")
    public void should_returnNEWLINE_when_WinningTypeIsNone() {
        WinningType winningType = WinningType.NONE;

        String message = winningType.getMessage();

        assertThat(message).doesNotContain(NEW_LINE.getMessage());
    }
}