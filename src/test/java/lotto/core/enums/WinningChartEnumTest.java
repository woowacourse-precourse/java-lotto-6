package lotto.core.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningChartEnumTest {
    @DisplayName("당첨번호와 일치하는 숫자의 수와 보너스번호 당첨여부에 따라서 Enum 값 여부가 달라진다.")
    @ParameterizedTest
    @CsvSource({"5,true,FIVE_AND_BONUS_MATCH", "5,false,FIVE_MATCH", "4,true,FOUR_MATCH", "3,true,THREE_MATCH",
            "2,false,NO_MATCH", "1,true,NO_MATCH", "0,true,NO_MATCH"})
    void valueOf(Integer matchCount, Boolean bonusNumber, String winningChartName) {
        //when
        WinningChartEnum winningChartEnum = WinningChartEnum.valueOf(matchCount, bonusNumber);

        //then
        assertThat(winningChartEnum.name()).isEqualTo(winningChartName);
    }
}