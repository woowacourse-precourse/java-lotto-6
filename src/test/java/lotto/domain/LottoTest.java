package lotto.domain;

import static lotto.domain.constant.ErrorMessages.NOT_UNIQUE;
import static lotto.domain.constant.ErrorMessages.NUMBER_OF_LOTTO;
import static lotto.domain.constant.ErrorMessages.RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @ParameterizedTest
    @MethodSource("provideInvalidNumbersAndMessage")
    @DisplayName("로또 번호는 6개이다. 숫자는 1이상 45이하이며 중복이 발생하면 안 된다. 조건을 만족하지 못할 경우 예외가 발생한다.")
    void validLottoNumberTest(List<Integer> numbers, String expectedMessage) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private static Stream<Arguments> provideInvalidNumbersAndMessage() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), NUMBER_OF_LOTTO.getMessage()),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), NOT_UNIQUE.getMessage()),
                Arguments.of(List.of(0, 2, 3, 4, 5, 46), RANGE_NUMBER.getMessage())
        );
    }

    @DisplayName("로또끼리 비교하여 같은 것의 개수를 센다.")
    @Test
    void compareLotto() {
        Lotto A = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto B = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        assertThat(A.compareTo(B)).isEqualTo(5);

        Lotto C = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        assertThat(A.compareTo(C)).isEqualTo(0);
    }

    @DisplayName("로또는 항상 오름차순으로 기록된다.")
    @Test
    void ascendingLotto() {
        Lotto input = new Lotto(new ArrayList<>(List.of(4, 1, 3, 2, 6, 5)));
        Lotto goal = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(input.toString()).isEqualTo(goal.toString());
    }
}