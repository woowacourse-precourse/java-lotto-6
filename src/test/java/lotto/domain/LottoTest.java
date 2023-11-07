package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @DisplayName("로또 번호에 1보다 작거나 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource
    void createLottoByUnderMinNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> createLottoByUnderMinNumber() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void createLotto(List<Integer> numbers) {
        List<LottoNumber> expected = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        List<LottoNumber> actual = lotto.getNumbers();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<List<Integer>> createLotto() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(40, 41, 42, 43, 44, 45)
        );
    }
}
