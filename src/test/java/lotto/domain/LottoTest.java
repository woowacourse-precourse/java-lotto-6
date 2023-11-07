package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    Winning winning = new Winning("1,2,3,4,5,6");
    Bonus bonus = new Bonus(winning, "7");

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSizeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumberTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1 ~ 45를 벗어난 경우 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumberTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤한 6개의 로또 번호를 생성한다.")
    @Test
    void generateLottoNumbersTest() {
        Lotto lotto = Lotto.generateLottoNumbers();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또 당첨 내역을 계산한다. (1등)")
    @Test
    void checkResultFirstTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkResult(winning, bonus)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또 당첨 내역을 계산한다. (2등)")
    @Test
    void checkResultSecondTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.checkResult(winning, bonus)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 당첨 내역을 계산한다. (3등)")
    @Test
    void checkResultThirdTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(lotto.checkResult(winning, bonus)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 당첨 내역을 계산한다. (4등)")
    @Test
    void checkResultFourthTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        assertThat(lotto.checkResult(winning, bonus)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또 당첨 내역을 계산한다. (5등)")
    @Test
    void checkResultFifthTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto.checkResult(winning, bonus)).isEqualTo(Rank.FIFTH);
    }
}