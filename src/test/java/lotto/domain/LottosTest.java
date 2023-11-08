package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.constant.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;
    private WinningNumber winningNumber;
    private Integer bonus;

    @BeforeEach
    void initiate() {
        Lottos l = new Lottos();
        l.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        l.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        l.add(new Lotto(List.of(1, 3, 5, 7, 9, 11)));
        l.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        this.lottos = l;

        this.winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 10));
        this.bonus = 6;
    }

    @Test
    void add() {
        lottos.add(new Lotto(List.of(2, 3, 4, 7, 8, 9)));

        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void getTotalReward() {
        Integer totalReward = lottos.getTotalReward(winningNumber, bonus);
        Integer expected = Rewards.SECOND.getValue() + Rewards.FIFTH.getValue() * 3;

        assertThat(totalReward).isEqualTo(expected);
    }

    @Test
    void getTotalStats() {
        Map<Rewards, Integer> totalStats = lottos.getTotalStats(winningNumber, bonus);

        assertThat(totalStats).containsEntry(Rewards.FIFTH, 3);
        assertThat(totalStats).containsEntry(Rewards.FOURTH, 0);
        assertThat(totalStats).containsEntry(Rewards.THIRD, 0);
        assertThat(totalStats).containsEntry(Rewards.SECOND, 1);
        assertThat(totalStats).containsEntry(Rewards.FIRST, 0);
        assertThat(totalStats).containsEntry(Rewards.LOSE, 0);
    }
}