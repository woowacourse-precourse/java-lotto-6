package lotto.model;

import static lotto.constants.ErrorMessage.ERROR_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumTest {
    private final BonusNum sample = new BonusNum();
    private final WinningNumbers numberSample = new WinningNumbers();

    @ParameterizedTest
    @DisplayName("입력한 보너스 번호가 유효한 번호면 정수로 변환한 값을 반환")
    @CsvSource(value = {"'1',1", "'45', 45"})
    void getBonusNum_test(String input, int expected) {
        Lotto lottoSample = numberSample.getLotto("8,21,23,41,42,43");
        assertThat(sample.getBonusNum(input, lottoSample)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력한 보너스 번호를 정수로 변환할 수 없으면 에러메시지 출력 ")
    @ValueSource(strings = {"1a", "4.0"})
    void validate_integerTest(String input) {
        Lotto lottoSample = numberSample.getLotto("8,21,23,41,42,43");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input, lottoSample));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("입력한 보너스 번호가 1~45 사이 정수가 아니면 에러메시지 출력 ")
    @ValueSource(strings = {"0", "46"})
    void validate_positiveTest(String input) {
        Lotto lottoSample = numberSample.getLotto("8,21,23,41,42,43");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input, lottoSample));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("입력한 보너스 번호가 6개의 로또 번호와 중복되면 에러메시지 출력")
    @ValueSource(strings = {"8", "21", "23", "41", "42", "43"})
    void validate_duplicatedBonusTest(String input) {
        Lotto lottoSample = numberSample.getLotto("8,21,23,41,42,43");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input, lottoSample));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
    }
}