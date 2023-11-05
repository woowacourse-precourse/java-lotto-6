package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerCalculatorTest {
    private LottoFactory lottoFactory;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private WinnerCalculator winnerCalculator;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory(0) {
            @Override
            public List<Lotto> getTickets() {
                return Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)),
                        new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                        new Lotto(Arrays.asList(1, 2, 14, 15, 16, 17))
                );
            }
        };
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(winningLotto, null) {
            @Override
            public int getBonusNumber() {
                return 7;
            }
        };
        winnerCalculator = new WinnerCalculator(lottoFactory, winningLotto, bonusNumber);
    }

    @DisplayName("당첨자 계산을 올바르게 수행하는지 테스트")
    @Test
    void testWinnerCalculation() {
        LinkedHashMap<LottoRank, Integer> result = winnerCalculator.calculate();

        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.NONE)).isEqualTo(1);
    }

    @DisplayName("초기 당첨자 수가 모두 0으로 설정되어 있는지 테스트")
    @Test
    void testInitialWinnerCount() {
        LinkedHashMap<LottoRank, Integer> initNumber = winnerCalculator.getWinnerCount();

        assertThat(initNumber.values()).allMatch(number -> number == 0);
    }

}



