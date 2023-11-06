package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.result.WinningRank;
import lotto.domain.result.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class LottosTest {

    @Test
    @DisplayName("WinningResult 구하는 기능 테스트")
    void WinningResult_test() {
        // given
        Map<WinningRank, Integer> expectedWinningResult = new EnumMap<>(WinningRank.class);
        expectedWinningResult.put(WinningRank.FIRST, 1);
        expectedWinningResult.put(WinningRank.SECOND, 1);
        expectedWinningResult.put(WinningRank.THIRD, 1);
        expectedWinningResult.put(WinningRank.FOURTH, 1);
        expectedWinningResult.put(WinningRank.FIFTH, 1);
        WinningResult otherWinningResult = new WinningResult(expectedWinningResult);
        
        //when
        WinningResult winningResult = getWinningResult();

        // then
        Assertions.assertThat(winningResult).isEqualTo(otherWinningResult);
    }

    private static WinningResult getWinningResult() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        Lotto testLottoData1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto testLottoData2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto testLottoData3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto testLottoData4 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto testLottoData5 = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        Lottos lottos = new Lottos(List.of(testLottoData1, testLottoData2, testLottoData3, testLottoData4, testLottoData5));
        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);
        return winningResult;
    }
}