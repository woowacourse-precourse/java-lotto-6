package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberExceptionTest {
    LottoNumberException lottoNumberException = new LottoNumberException();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      "})
    @DisplayName("빈칸을 입력 하면 예외가 발생 한다.")
    void checkBlank(String input) {
        assertThatThrownBy(() -> lottoNumberException.checkBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "100", "-1"})
    @DisplayName("입력한 번호가 가능한 로또 번호 범위를 넘어가면 예외가 발생 한다.")
    void checkLottoNumber(String input) {
        assertThatThrownBy(() -> lottoNumberException.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 입력이 숫자로 끝나지 않으면 예외가 발생 한다.")
    void checkEndWithNumber() {
        assertThatThrownBy(() -> lottoNumberException.checkLottoNumber("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3", "a,b,3,4,e,f"})
    @DisplayName("6개의 숫자를 입력 하지 않으면 예외가 발생 한다.")
    void checkSixInputs(String input) {
        assertThatThrownBy(() -> lottoNumberException.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkInteger() {
    }

    @Test
    void checkSixNumbers() {
    }

    @Test
    void checkDuplicate() {
    }
}