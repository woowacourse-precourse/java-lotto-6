package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberInputManagerTest {

    @DisplayName("로또 당첨 번호 입력 포맷 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2,3,4,5,6 ", ",1,2,3,4,5,6", "1,2,3,4,5,6,", "a,1,2,3,4,5", "1,2,3, 4,5,6"})
    void inputIsNotAnswerNumber(String input) {
        assertThatThrownBy(() -> LottoNumberInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_LOTTO_NUMBER_INPUT);
    }

    @DisplayName("로또 당첨 번호 크기 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5", "12233333333333,1,2,3,4,5"})
    void wrongLottoNumberSizeTest(String input) {
        assertThatThrownBy(() -> LottoNumberInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_LOTTO_NUMBER_SIZE);
    }

    @DisplayName("로또 당첨 번호 중복 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,1,1,1,1"})
    void duplicateLottoNumbers(String input) {
        assertThatThrownBy(() -> LottoNumberInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
    }

    @DisplayName("정상 동적 테스트")
    @ParameterizedTest
    @MethodSource("okParameter")
    void ok(String input, List<Integer> expected) {
        List<Integer> lottoNumbers = LottoNumberInputManager.fromString(input);
        assertThat(lottoNumbers)
                .containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> okParameter() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6))
        );
    }
}