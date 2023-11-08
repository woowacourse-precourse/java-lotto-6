package lotto.domain;

import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;
    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @DisplayName("당첨 순위 1~5는 winningStats 맵의 key 1~5로 저장된다.")
    @Test
    void checkWinningLotto() {
        // Given
        Lottos purchasedLotto = new Lottos();
        purchasedLotto.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotto.addLotto(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        Lotto winningLotto = new Lotto(List.of(1,2,3,13,14,15));
        BonusNumber bonusNumber = new BonusNumber(16);
        Map<Integer, Integer> winningStats = new HashMap<>();
        winningStats.put(1, 0);
        winningStats.put(2, 0);
        winningStats.put(3, 0);
        winningStats.put(4, 0);
        winningStats.put(5, 1);

        // When
        computer.checkWinningLotto(purchasedLotto, winningLotto, bonusNumber, winningStats);

        // Then
        assertThat(winningStats.get(1)).isEqualTo(0);
        assertThat(winningStats.get(2)).isEqualTo(0);
        assertThat(winningStats.get(3)).isEqualTo(0);
        assertThat(winningStats.get(4)).isEqualTo(0);
        assertThat(winningStats.get(5)).isEqualTo(1);
    }

    @DisplayName("숫자가 5개 일치하고 보너스 번호가 일치하면 winningStats 맵의 2번 키의 값이 증가한다.")
    @Test
    void checkWinningLottocontainingBonusNumber() {
        // Given
        Lottos purchasedLotto = new Lottos();
        purchasedLotto.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotto.addLotto(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,15));
        BonusNumber bonusNumber = new BonusNumber(6);
        Map<Integer, Integer> winningStats = new HashMap<>();
        winningStats.put(1, 0);
        winningStats.put(2, 1);
        winningStats.put(3, 0);
        winningStats.put(4, 0);
        winningStats.put(5, 0);

        // When
        computer.checkWinningLotto(purchasedLotto, winningLotto, bonusNumber, winningStats);

        // Then
        assertThat(winningStats.get(1)).isEqualTo(0);
        assertThat(winningStats.get(2)).isEqualTo(1);
        assertThat(winningStats.get(3)).isEqualTo(0);
        assertThat(winningStats.get(4)).isEqualTo(0);
        assertThat(winningStats.get(5)).isEqualTo(0);
    }

    @DisplayName("로또 게임의 수익률을 계산한다.")
    @Test
    void calcRateOfProfit() {
        // Given
        Map<Integer, Integer> winningStats = new HashMap<>();
        winningStats.put(1, 0);
        winningStats.put(2, 0);
        winningStats.put(3, 0);
        winningStats.put(4, 0);
        winningStats.put(5, 1);
        int purchaseAmount = 8000;
        String expectedRateOfProfit = "62.5";

        // When
        computer.calcRateOfProfit(winningStats, purchaseAmount);

        // Then
        assertThat(Computer.rateOfProfit).isEqualTo(expectedRateOfProfit);
    }
}