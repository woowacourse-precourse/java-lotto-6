package lotto.model;

import lotto.constant.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(
            () -> new WinningLotto("1,2,3,4,5,6,7", "8")
        )
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 6개 중 정수가 아닌 입력이 있으면 예외가 발생한다.")
    @Test
    void notIntegerNumber() {
        assertThatThrownBy(
            () -> new WinningLotto("1,2,ased,34,4,5", "6")
        )
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void bonusDuplicate() {
        assertThatThrownBy(
            () -> new WinningLotto("1,2,3,4,5,6,7", "5")
        )
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void bonusNotInteger() {
        assertThatThrownBy(
                () -> new WinningLotto("1,2,3,4,5,6,7", "a2sd")
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등인 로또 번호 결과가 나온다.")
    @Test
    void getlottoResultFirst() {
        Lotto lotto = new Lotto(List.of(1, 4, 5, 6, 8, 10));
        WinningLotto winningLotto = new WinningLotto("1,4,5,6,8,10", "2");
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(LottoResult.FIRST);
    }

    @DisplayName("2등인 로또 번호 결과가 나온다.")
    @Test
    void getlottoResultSecond() {
        Lotto lotto = new Lotto(List.of(1, 4, 5, 6, 8, 2));
        WinningLotto winningLotto = new WinningLotto("1,4,5,6,8,10", "2");
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("3등인 로또 번호 결과가 나온다.")
    @Test
    void getlottoResultThird() {
        Lotto lotto = new Lotto(List.of(1, 4, 5, 6, 8, 7));
        WinningLotto winningLotto = new WinningLotto("1,4,5,6,8,10", "2");
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("4등인 로또 번호 결과가 나온다.")
    @Test
    void getlottoResultFourth() {
        Lotto lotto = new Lotto(List.of(1, 4, 5, 6, 11, 7));
        WinningLotto winningLotto = new WinningLotto("1,4,5,6,8,10", "2");
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(LottoResult.FOURTH);
    }

    @DisplayName("5등인 로또 번호 결과가 나온다.")
    @Test
    void getlottoResultFifth() {
        Lotto lotto = new Lotto(List.of(1, 4, 5, 12, 11, 7));
        WinningLotto winningLotto = new WinningLotto("1,4,5,6,8,10", "2");
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(LottoResult.FIFTH);
    }

    @DisplayName("당첨되지 않은 로또 번호 결과가 나온다.")
    @Test
    void getlottoResultNothing() {
        Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        WinningLotto winningLotto = new WinningLotto("1,4,5,6,8,10", "2");
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(null);
    }
}
