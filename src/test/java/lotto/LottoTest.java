package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨된 갯수를 확인하는 메소드에 6개가 아닌 로또 번호가 인자로 들어오면 예외를 발생한다.")
    @Test
    void calcMatchNumberOverLottoNumberCheck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨된 갯수를 확인하는 메소드에 중복된 로또 번호가 인자로 들어오면 예외를 발생한다.")
    @Test
    void calcMatchNumberDuplicatedLottoNumberCheck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨된 갯수를 확인하는 메소드에 1 ~ 45 밖의 로또 번호가 인자로 들어오면 예외를 발생한다.")
    @Test
    void calcMatchNumberNotIn1To45LottoNumberCheck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(0, 1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5, 46), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨된 갯수를 확인하는 메소드에 보너스 번호가 1 ~ 45 이외의 숫자가 인자로 들어오면 예외를 발생한다.")
    @Test
    void calcMatchNumberNotIn1To45BonusNumberCheck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨된 갯수를 확인하는 메소드에 보너스 번호가 로또 번호와 중복된 숫자가 인자로 들어오면 예외를 발생한다.")
    @Test
    void calcMatchNumberDuplicatedBonusNumberCheck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.calcMatchNumber(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}