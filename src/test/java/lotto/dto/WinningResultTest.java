package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.WinningType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningResultTest {
    private WinningResult winningResult;

    @BeforeEach
    void init() {
        winningResult = new WinningResult();
    }

    @ParameterizedTest(name = "{0}개의 번호가 당첨되고, 보너스 당첨 여부가 {1}일 때, 당첨 유형은 {2}이다.")
    @DisplayName("당첨개수와 보너스 당첨 여부에 따라 결과를 저장한다")
    @CsvSource({
            "3, false, THREE",
            "4, false, FOUR",
            "5, false, FIVE",
            "5, true, FIVE_BONUS",
            "6, false, SIX"
    })
    public void should_saveResult_when_byWinningAndBonus(int matchedCount, boolean isBonus,
                                                         WinningType key) {
        //given
        winningResult.updateResult(matchedCount, isBonus);

        //when
        Integer count = winningResult.getWinningMap().get(key);

        //then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨개수를 모두 확인한 이후, 총 당첨금을 계산할 수 있다.")
    public void should_calculate_when_afterCheckWinning() {
        //given
        winningResult.updateResult(3, false);
        winningResult.updateResult(3, false);
        winningResult.updateResult(4, false);
        winningResult.updateResult(5, true);

        //when
        int totalPrize = winningResult.getTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(30_060_000);
    }
}