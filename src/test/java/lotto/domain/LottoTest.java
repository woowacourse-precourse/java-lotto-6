package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLotto_WithInvalidSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLotto_WithDuplicateNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1부터 45까지가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void createLotto_WithInvalidRange(String testName, List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("음수가 존재하는 경우", List.of(-1, 2, 3, 4, 5, 6)),
                arguments("0이 존재하는 경우", List.of(0, 1, 2, 3, 4, 5)),
                arguments("45를 초과하는 수가 존재하는 경우", List.of(1, 2, 3, 4, 5, 46))
        );
    }
}