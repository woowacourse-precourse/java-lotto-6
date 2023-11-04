package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    static Stream<Arguments> provideInvalidNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(-32, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 999))
        );
    }

    @DisplayName("랜덤으로 발급된 로또번호가 규정범위를 벗어난 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void createLottoNumberThrowExceptionWhenNumbersAreOutOfRange(List<Integer> numbers) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.validateNumberRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1 ~ 45 사이로 발급되어야 합니다.");
    }


}