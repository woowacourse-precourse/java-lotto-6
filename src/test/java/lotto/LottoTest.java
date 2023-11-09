package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위 초과의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRangedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 99)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위 미만의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRangedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두개의 로또 에서 중복된 숫자 개수를 센다.")
    @Test
    void countDuplicatingNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        int result = lotto.countDuplicatingNumbers(other);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("로또 에 보너스 번호를 포함할 경우 참을 반환한다.")
    @Test
    void tryIsContainBonusNumberWithBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int input = 3;
        boolean result = lotto.isContainBonusNumber(input);

        assertThat(result).isEqualTo(true);
    }

    @DisplayName("로또 에 보너스 번호를 포함하지 않을 경우 거짓을 반환한다.")
    @Test
    void tryIsContainBonusNumberWithoutBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int input = 7;
        boolean result = lotto.isContainBonusNumber(input);

        assertThat(result).isEqualTo(false);
    }

    @DisplayName("로또에 해당하는 숫자 리스트를 반환한다.")
    @Test
    void getNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> result = lotto.getNumbers();

        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}