package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {
    @DisplayName("복권 결과 기본 생성 - 결과는 정상적으로 초기화 되어야 한다.")
    @Test
    void createWinningResultDefault() {
        WinningResult result = new WinningResult();

        // 개별 당첨 개수 확인
        for (WinningType type : WinningType.values()) {
            int winningCountOfType = result.getWinningCountOfType(type);
            assertThat(winningCountOfType)
                    .isEqualTo(0);
        }

        assertThat(result.getLottoCount())
                .isEqualTo(0);
        assertThat(result.getWinningCount().size())
                .isEqualTo(LottoSetting.WINNING_TYPE_COUNT.getValue());
        assertThat(result.getTotalPrize())
                .isEqualTo(0);
    }

    @DisplayName("1등 당첨 테스트")
    @Test
    void createWinningResultByFirstCondition() {
        WinningType type = WinningType.FIRST;
        WinningResult result = getWinningResult(type);

        onlyOneTypeIsWon(type, result);
    }

    @DisplayName("2등 당첨 테스트")
    @Test
    void createWinningResultBySecondCondition() {
        WinningType type = WinningType.SECOND;
        WinningResult result = getWinningResult(type);

        onlyOneTypeIsWon(type, result);
    }

    @DisplayName("3등 당첨 테스트")
    @Test
    void createWinningResultByThirdCondition() {
        WinningType type = WinningType.THIRD;
        WinningResult result = getWinningResult(type);

        onlyOneTypeIsWon(type, result);
    }

    @DisplayName("4등 당첨 테스트")
    @Test
    void createWinningResultByFourthCondition() {
        WinningType type = WinningType.FOURTH;
        WinningResult result1 = getWinningResult(type);
        WinningResult result2 = new WinningResult(type.getMatchingCount(), true);

        onlyOneTypeIsWon(type, result1);
        onlyOneTypeIsWon(type, result2);
    }

    @DisplayName("5등 당첨 테스트")
    @Test
    void createWinningResultByFifthCondition() {
        WinningType type = WinningType.FIFTH;
        WinningResult result1 = getWinningResult(type);
        WinningResult result2 = new WinningResult(type.getMatchingCount(), true);

        onlyOneTypeIsWon(type, result1);
        onlyOneTypeIsWon(type, result2);
    }

    @DisplayName("당첨 없음")
    @Test
    void createWinningResultByNoneCondition() {
        for (int matched = -1; matched < 3; matched++) {
            WinningResult result1 = new WinningResult(matched, false);
            WinningResult result2 = new WinningResult(matched, true);

            // 개별 당첨 개수 확인
            for (WinningType type : WinningType.values()) {
                assertThat(result1.getWinningCountOfType(type))
                        .isEqualTo(0);
                assertThat(result2.getWinningCountOfType(type))
                        .isEqualTo(0);
            }
        }
    }

    @DisplayName("로또 결과 합치기")
    @Test
    void testAdd() {
        WinningResult firstResult = getWinningResult(WinningType.FIRST);
        WinningResult thirdResult = getWinningResult(WinningType.THIRD);
        WinningResult result = new WinningResult();
        long expectedPrize = 0L;

        result.add(firstResult);
        expectedPrize += WinningType.FIRST.getPrize();
        assertThat(result.getLottoCount()).isEqualTo(1);
        assertThat(result.getWinningCountOfType(WinningType.FIRST)).isEqualTo(1);
        assertThat(result.getTotalPrize()).isEqualTo(expectedPrize);

        result.add(thirdResult);
        expectedPrize += WinningType.THIRD.getPrize();
        assertThat(result.getLottoCount()).isEqualTo(2);
        assertThat(result.getWinningCountOfType(WinningType.FIRST)).isEqualTo(1);
        assertThat(result.getWinningCountOfType(WinningType.THIRD)).isEqualTo(1);
        assertThat(result.getTotalPrize()).isEqualTo(expectedPrize);

        result.add(thirdResult);
        expectedPrize += WinningType.THIRD.getPrize();
        assertThat(result.getLottoCount()).isEqualTo(3);
        assertThat(result.getWinningCountOfType(WinningType.FIRST)).isEqualTo(1);
        assertThat(result.getWinningCountOfType(WinningType.THIRD)).isEqualTo(2);
        assertThat(result.getTotalPrize()).isEqualTo(expectedPrize);

        result.add(result);
        expectedPrize += expectedPrize;
        assertThat(result.getLottoCount()).isEqualTo(6);
        assertThat(result.getWinningCountOfType(WinningType.FIRST)).isEqualTo(2);
        assertThat(result.getWinningCountOfType(WinningType.THIRD)).isEqualTo(4);
        assertThat(result.getTotalPrize()).isEqualTo(expectedPrize);

    }

    private WinningResult getWinningResult(WinningType type) {
        int matched = type.getMatchingCount();
        boolean bonusMatched = type.getBonusMatching();
        return new WinningResult(matched, bonusMatched);
    }

    private void onlyOneTypeIsWon(WinningType type, WinningResult result) {
        int numberOfWins = result.getWinningCountOfType(type);
        assertThat(numberOfWins)
                .isEqualTo(1);
        for (WinningType other : WinningType.values()) {
            if (other != type) {
                assertThat(result.getWinningCountOfType(other))
                        .isEqualTo(0);
            }
        }
    }
}