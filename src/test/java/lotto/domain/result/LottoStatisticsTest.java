package lotto.domain.result;

import lotto.constants.lotto.WinningFactor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 통계 객체에 대해")
class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @Test
    @DisplayName("생성시 통계 자료를 당첨 요소를 키로, 0을 값으로 초기화한다.")
    void Given_InitStatistics_When_GetStatistics_Then_ContainsEntry() {
        //when
        Map<WinningFactor, Integer> actualStatistics = lottoStatistics.getStatistics();

        //then
        assertThat(actualStatistics).isNotNull().isNotEmpty().hasSize(WinningFactor.values().length);

        for (WinningFactor expectFactor : WinningFactor.values()) {
            assertThat(actualStatistics).containsEntry(expectFactor, 0);
        }
    }

    @Test
    @DisplayName("당첨 했을 시 요소의 값을 하나 더 한다.")
    void Given_ThreeMatch_When_UpThreeMatchFactorValue_Then_Up1() {
        //given
        Integer matchCount = 3;
        Boolean isMatchBonusNumber = false;

        //when
        lottoStatistics.upWinningFactorValue(matchCount, isMatchBonusNumber);
        Map<WinningFactor, Integer> statistics = lottoStatistics.getStatistics();
        Integer actual = statistics.get(WinningFactor.THREE_MATCH);

        //then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 금액의 합을 구한다.")
    void Given_ThreeMatch_When_calculateWinningPriceThen_() {
        //given
        lottoStatistics.upWinningFactorValue(3, false);
        lottoStatistics.upWinningFactorValue(4, false);

        //when
        Integer actual = lottoStatistics.calculateWinningPrice();

        //then
        assertThat(actual).isEqualTo(55_000);
    }
}
