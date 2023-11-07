package lotto.domain.lotto;

import lotto.domain.winningNumber.BonusNumber;
import lotto.domain.winningNumber.FinalWinningNumber;
import lotto.domain.winningNumber.WinningNumber;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LottosTest {

    static Lottos lottos;
    static FinalWinningNumber finalWinningNumber;

    @BeforeAll
    static void initLottos() {
        lottos = new Lottos(5000);
        lottos.lottos.clear();
        lottos.lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.lottos.add(new Lotto(List.of(1, 2, 3, 8, 12, 14)));

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        finalWinningNumber = new FinalWinningNumber(winningNumber, bonusNumber);
    }

    @DisplayName("구매 금액에 따른 로또 개수 반환")
    @Test
    @Order(1)
    void testLottosNumberOfLotto() {
        assertThat(lottos.getNumberOfLotto()).isEqualTo(5);
    }

    @DisplayName("로또 당첨 종합 순위 테스트")
    @Test
    @Order(2)
    void testLottosRank() {
        HashMap<LottoRank, Integer> testMap = new LinkedHashMap<>();
        testMap.put(LottoRank.FIFTH_PLACE, 2);
        testMap.put(LottoRank.FOURTH_PLACE, 1);
        testMap.put(LottoRank.THIRD_PLACE, 0);
        testMap.put(LottoRank.SECOND_PLACE, 1);
        testMap.put(LottoRank.FIRST_PLACE, 1);

        assertThat(lottos.getLottosResult(finalWinningNumber))
                .isEqualTo(testMap);
    }

    @DisplayName("수익률 테스트")
    @Test
    @Order(3)
    void testTotalRateOfReturn() {
        assertThat(lottos.calculateTotalRateOfReturn())
                .isEqualTo(40601200.0);
    }
}
