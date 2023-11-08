package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoGeneratorTest {
    @DisplayName("입력한 로또 번호가 빈칸인 경우 예외를 발생시킨다.")
    @Test
    void createWinningLottoNumberByBlank() {
        assertThatThrownBy(() -> WinningLottoGenerator.generateLottoNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 번호가 6개 미만인 경우 예외를 발생시킨다.")
    @Test
    void createWinningLottoNumberByUnderSize() {
        assertThatThrownBy(() -> WinningLottoGenerator.generateLottoNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 번호가 6개를 초과한 경우 예외를 발생시킨다.")
    @Test
    void createWinningLottoNumberByOverSize() {
        assertThatThrownBy(() -> WinningLottoGenerator.generateLottoNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 번호가 45를 초과한 경우 예외를 발생시킨다.")
    @Test
    void createWinningLottoNumberByNumberOverSize() {
        assertThatThrownBy(() -> WinningLottoGenerator.generateLottoNumber("1,2,3,46,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 번호가 1보다 작은 경우 예외를 발생시킨다.")
    @Test
    void createWinningLottoNumberByNumberUnderSize() {
        assertThatThrownBy(() -> WinningLottoGenerator.generateLottoNumber("1,2,3,0,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 번호가 정수 이외 값을 입력한 경우 예외를 발생시킨다.")
    @Test
    void createWinningLottoNumberByNotInteger() {
        assertThatThrownBy(() -> WinningLottoGenerator.generateLottoNumber("1,2,3,notNumber,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
