package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
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
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 이상 45 이하의 범위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("outOfRangeNumberTest")
    void createLottoByOutOfRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("[ERROR] 각 로또 숫자의 범위는 1 이상 45 이하여야 합니다. 현재 입력한 번호 : %s", numbers));
    }

    static Stream<Arguments> outOfRangeNumberTest() {
        return Stream.of(
                arguments(List.of(0, 1, 2, 3, 4, 5)),
                arguments(List.of(-1, 1, 2, 3, 4, 5)),
                arguments(List.of(46, 1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호를 반환한다.")
    @Test
    void getNumbersTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(numbers.get(i));
        }
    }
}
