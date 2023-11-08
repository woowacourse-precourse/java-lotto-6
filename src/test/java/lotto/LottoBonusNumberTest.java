package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBonusNumberTest {

    @DisplayName("유효한 보너스 번호일 경우 예외가 발생하지 않아야 한다.")
    @ParameterizedTest(name = "[{index}] 유효한 번호: {arguments}")
    @ValueSource(ints = {1, 45})
    void givenValidBonusNumber_whenCreatingLottoBonusNumber_thenNoException(int validNumber) {
        // When & Then
        assertThatCode(() -> new LottoBonusNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 보너스 번호일 경우 예외를 발생시켜야 한다.")
    @ParameterizedTest(name = "[{index}] 유효하지 않은 번호: {arguments}")
    @ValueSource(ints = {0, 46})
    void givenInvalidBonusNumber_whenCreatingLottoBonusNumber_thenExceptionIsThrown(int invalidNumber) {
        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoBonusNumber(invalidNumber))
                .withMessageMatching("로또 숫자의 범위는 \\d+에서 \\d+ 사이여야 합니다.");
    }
}
