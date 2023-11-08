package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        // 당첨번호: 1,2,3,4,5,6 보너스: 7
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumbers);
        winningLotto = new WinningLotto(lotto, 7);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 1등을 반환할 수 있다.")
    @Test
    void match_ReturnFirstPrize() {
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto userLotto = new Lotto(userNumbers);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Prize.FIRST);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 2등을 반환할 수 있다.")
    @Test
    void match_ReturnSecondPrize() {
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto userLotto = new Lotto(userNumbers);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Prize.SECOND);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 3등을 반환할 수 있다.")
    @Test
    void match_ReturnThirdPrize() {
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 8);
        Lotto userLotto = new Lotto(userNumbers);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Prize.THIRD);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 4등을 반환할 수 있다.")
    @Test
    void match_ReturnFourthPrize() {
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 9, 10);
        Lotto userLotto = new Lotto(userNumbers);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 5등을 반환할 수 있다.")
    @Test
    void match_ReturnFifthPrize() {
        List<Integer> userNumbers = List.of(1, 2, 3, 11, 9, 10);
        Lotto userLotto = new Lotto(userNumbers);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 NONE 반환할 수 있다.")
    @Test
    void match_ReturnNoPrize() {
        List<Integer> userNumbers = List.of(9, 10, 11, 12, 13, 14);
        Lotto userLotto = new Lotto(userNumbers);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Prize.NONE);
    }

}