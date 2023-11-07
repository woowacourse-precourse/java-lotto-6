package lotto.model;

import static lotto.constants.ErrorMessage.ERROR_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    private final WinningNumbers sample = new WinningNumbers();

    @ParameterizedTest
    @DisplayName("입력된 당첨번호 6개가 모두 유효한 숫자이면 오름차순 정렬 후 당첨번호에 관한 로또 객체 생성")
    @MethodSource("sampleNumbers")
    void getLotto_normalTest(String input, List<Integer> expected) {
        Lotto result = sample.getLotto(input);
        assertThat(result.getWinningNumbers()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력된 당첨번호 6개 중 1개라도 유효한 숫자가 아니면 IllegalArgumentException 예외 발생")
    @ValueSource(strings = {
            "8,21,23,41,42,46", "8,21,0,41,42,43", "8,-1,23,41,42,43",
            "8,21,23,1a,42,43", "4.0,21,23,41,42,43"
    })
    void getLotto_exceptionTest(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.getLotto(input));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("1개의 숫자 토큰을 정수로 변환할 수 없으면 에러 메시지 출력")
    @ValueSource(strings = {"1a", "4.0"})
    void validate_integerTest(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("1개의 숫자 토큰을 정수로 변환한 값이 1~45 사이 숫자가 아니면 에러 메시지 출력")
    @ValueSource(strings = {"-1", "0", "46"})
    void validate_rangeTest(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
    }

    private static Stream<Arguments> sampleNumbers() {
        return Stream.of(
                Arguments.of("8,21,23,41,42,43", List.of(8, 21, 23, 41, 42, 43)),
                Arguments.of("5,11,3,32,16,38", List.of(3, 5, 11, 16, 32, 38)),
                Arguments.of("44,36,35,16,11,7", List.of(7, 11, 16, 35, 36, 44))
        );
    }
}