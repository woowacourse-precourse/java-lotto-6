package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("1 미만, 45 초과의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateWrongRangeNumber")
    void createLottoByWrongRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateWrongRangeNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 0, 4, 5, 6)),
                Arguments.of(List.of(10, 11, 12, 45, 50, 23))
        );
    }

    @DisplayName("로또 번호가 정렬이 되는지 확인한다.")
    @Test
    void sortedLottoNumber() {        
        List<Integer> numbers = List.of(6, 4, 5, 2, 1, 3);
        List<Integer> answerNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.toString()).isEqualTo(answerNumbers.toString());
    }
}