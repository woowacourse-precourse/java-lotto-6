package lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningCombination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawingMachineTest {
    private DrawingMachine drawingMachine;
    private WinningCombination winningCombination;

    @BeforeEach
    void setUp() {
        drawingMachine = new DrawingMachine();

        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);
        winningCombination = WinningCombination.of(winningNumbers, bonusNumber);
    }


    @DisplayName("DrawingMachine은 WinningCombination과 purchasedLotto를 통헤 당첨 결과를 생성한다")
    @Test
    void should_calculate_DrawingResult() {
        // given
        Lottos totalLottoTickets = createLottos();

        EnumMap<LottoRank, Integer> expectedResult = initializeExpectedResult();
        expectedResult.put(LottoRank.FIRST, 1);
        expectedResult.put(LottoRank.SECOND, 1);
        expectedResult.put(LottoRank.THIRD, 1);

        // when
        PrizeStatistics prizeStatistics = drawingMachine.draw(winningCombination, totalLottoTickets);

        // then
        assertThat(prizeStatistics.getDrawingResult()).isEqualTo(expectedResult);
    }

    private List<Lotto> generateLottos() {
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto2 = Lotto.from(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lotto3 = Lotto.from(List.of(1, 2, 3, 4, 5, 8)); // 3등
        return List.of(lotto1, lotto2, lotto3);
    }

    private Lottos createLottos() {
        List<Lotto> lottos = generateLottos();
        return Lottos.from(lottos);
    }

    private EnumMap<LottoRank, Integer> initializeExpectedResult() {
        EnumMap<LottoRank, Integer> expectedDrawingResult = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.ranks) {
            expectedDrawingResult.put(rank, 0);
        }
        return expectedDrawingResult;
    }
}