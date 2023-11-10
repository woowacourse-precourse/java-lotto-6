package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("1~45 의 서로 다른 6개의 당첨번호를 생성한다.")
    @Test
    void createWinningNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);

        // then
        assertThat(winningNumbers.getNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest(name = "[{index}] 당첨번호가 ''{0}'' 이면 예외가 발생한다.")
    @MethodSource("provideNumbers")
    void cannotCreateWinningLottos(List<Integer> numbers) {
        assertThatThrownBy(() -> WinningNumbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(List.of(1,2,3 ,4)),
                Arguments.of(List.of(1,1,2,3,4,5)),
                Arguments.of(List.of(-1,4,5,6,7,8)),
                Arguments.of(List.of(1,46,3,4,5,6)));
    }
}