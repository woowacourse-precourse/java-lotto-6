package lotto;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    @DisplayName("로또 번호가 정상 데이터로 이루어져있는 경우에 대해 검증합니다.")
    @Test
    void createLottoByNormalNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers()).isEqualTo(expectedResult);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 빈 값을 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void checkInputIsNotEmpty() {
        assertThatThrownBy(() -> new Lotto(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 띄어쓰기만 입력한 경우, 예외를 발생시킵니다.")
    @Test
    void checkInputIsSpace() {
        assertThatThrownBy(() -> new Lotto("    "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 문자열 리스트에 숫자와 문자가 모두 있는 경우, 예외를 발생시킵니다.")
    @Test
    void checkListDigitWithString() {
        assertThatThrownBy(() -> new Lotto("1,2,3,a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 쉼표 구분의 값이 6개를 넘은 경우, 예외를 발생시킵니다.")
    @Test
    void check7Numbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 쉼표 구분의 값이 6개가 되지 않는 경우, 예외를 발생시킵니다.")
    @Test
    void check5Numbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 45를 초과하는 값이 있는 경우, 예외를 발생시킵니다.")
    @Test
    void checkOutOfRangeNumbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,54"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 1 미만의 값이 있는 경우, 예외를 발생시킵니다.")
    @Test
    void checkOutOfRangeNumbers2() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 대해 검증합니다. 중복되는 값이 있는 경우, 예외를 발생시킵니다.")
    @Test
    void checkDuplicateNumbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}