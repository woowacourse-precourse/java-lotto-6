package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @Test
    @DisplayName("리스트의 크기가 6이 아니면 예외가 발생 한다.")
    void checkSixInputs() {
        assertThatThrownBy(() -> lottoNumberException.checkSixInputs(List.of("1", "1", "1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-123", "abc123"})
    @DisplayName("정수가 아니면 예외가 발생 한다.")
    void checkInteger(String input) {
        assertThatThrownBy(() -> lottoNumberException.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(" 예외가 발생 한다.")
    void checkSixNumbers() {
        assertThatThrownBy(() -> lottoNumberException.checkSixNumbers(List.of("1", "a", "3", "b", "5", "c")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkDuplicate() {

    }
}