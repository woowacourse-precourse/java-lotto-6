package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningStatusTest {
    @ParameterizedTest
    @CsvSource(value = {"MATCH3, 1", "MATCH4, 2", "MATCH5, 5", "MATCH5_WITH_BONUS, 10", "MATCH6, 100"})
    @DisplayName("당첨타입 개수 추가")
    void 당첨_타입_개수_추가(PrizeType prizeType, int count) {
        //given
        WinningStatus winningStatus = new WinningStatus();

        //when
        for (int i = 0; i < count; i++) {
            winningStatus.add(prizeType);
        }

        assertThat(winningStatus.getSum(prizeType)).isEqualTo(prizeType.getPrize() * count);
    }

    @ParameterizedTest
    @CsvSource(value = {"MATCH3, 1", "MATCH4, 2", "MATCH5, 5", "MATCH5_WITH_BONUS, 10", "MATCH6, 100"})
    @DisplayName("총 상금 계산")
    void 총_상금_계산(PrizeType prizeType, int count) {
        //given
        WinningStatus winningStatus = new WinningStatus();

        //when
        for (int i = 0; i < count; i++) {
            winningStatus.add(prizeType);
        }

        assertThat(winningStatus.getSum()).isEqualTo((double) prizeType.getPrize() * count);
    }
}