package lotto.model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private Lotto winningLotto;
    private int bonusNumber;
    private WinningLotto winningLottoTest;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningLottoTest = new WinningLotto(winningLotto, bonusNumber);
    }

    @DisplayName("로또 1등 확인")
    @Test
    void 로또_1등_확인() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @DisplayName("로또 2등 확인")
    @Test
    void 로또_2등_확인() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @DisplayName("로또 3등 확인")
    @Test
    void 로또_3등_확인() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @DisplayName("로또 4등 확인")
    @Test
    void 로또_4등_확인() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("로또 5등 확인")
    @Test
    void 로또_5등_확인() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 미당첨 확인 - 2개만 일치")
    @Test
    void 로또_미당첨_확인1() {
        Lotto userLotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isNull();
    }

    @DisplayName("로또 미당첨 확인 - 1개만 일치")
    @Test
    void 로또_미당첨_확인2() {
        Lotto userLotto = new Lotto(List.of(1, 12, 8, 9, 10, 11));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isNull();
    }

    @DisplayName("로또 미당첨 확인 - 0개 일치")
    @Test
    void 로또_미당첨_확인3() {
        Lotto userLotto = new Lotto(List.of(13, 12, 8, 9, 10, 11));
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isNull();
    }
}