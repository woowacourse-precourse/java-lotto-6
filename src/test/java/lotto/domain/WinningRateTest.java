package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningRate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningRateTest {
    @DisplayName("WinningRate 생성 테스트")
    @Test
    void makeWinningRateTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.makeLotto(List.of(10, 11, 12, 13, 14, 15)));
        lottos.add(Lotto.makeLotto(List.of(20, 21, 22, 23, 24, 25)));
        Lottos lottosTest = Lottos.makeLottos(lottos);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.makeBonusNumber(7);
        Map<Integer, Integer> winningCount = new HashMap<>();
        winningCount.put(1, 1);
        winningCount.put(2, 0);
        winningCount.put(3, 0);
        winningCount.put(4, 0);
        winningCount.put(5, 0);
        winningCount.put(6, 2);
        long profitTest = 2000000000;
        WinningNumbers winningNumbersTest = WinningNumbers.makeWinningNumbers(lotto, bonusNumber);
        WinningRate winningRateTest = WinningRate.makeWinningRate(lottosTest.getLottos(), winningNumbersTest);
        assertThat(winningCount).isEqualTo(winningRateTest.getWinningCount());
        assertThat(profitTest).isEqualTo(winningRateTest.getProfit());
    }
}
