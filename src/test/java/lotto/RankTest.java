package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("당첨되지 않은 로또 1개의 당첨을 확인한다.")
    @Test
    void checkMissLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank result = Rank.checkLotto(lotto, List.of(10, 12, 13, 14, 15, 16), 17);
        assertThat(result).isEqualTo(Rank.MISS);
    }

    @DisplayName("1등 당첨된 로또 1개의 당첨을 확인한다.")
    @Test
    void checkFirstLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank result = Rank.checkLotto(lotto, List.of(1, 2, 3, 4, 5, 6), 17);
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등 당첨된 로또 1개의 당첨을 확인한다.")
    @Test
    void checkSecondLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Rank result = Rank.checkLotto(lotto, List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(result).isEqualTo(Rank.SECOND);
    }

}