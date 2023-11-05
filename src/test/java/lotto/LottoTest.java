package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 빈 입력이면 예외가 발생한다.")
    @Test
    void createLottoByEmptyNumber() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 50, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 음수면 예외가 발생한다.")
    @Test
    void createLottoByNaturalNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 소수면 예외가 발생한다.")
    @Test
    void createLottoByFloatNumber() {
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4.1,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotANumber() {
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,%,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 쉼표로 구분되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByNoComma() {
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,5#6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,5,,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,,,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}