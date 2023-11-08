package lotto.model.lotto;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.exception.lotto.LottoOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        //given
        List<Integer> numbers = Arrays.asList(11, 2, 3, 4, 5, 5);
        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("numbersOutOfRange")
    void createLottoOutOfRange(List<Integer> numbersOutOfRange) {
        // when & then
        assertThatThrownBy(() -> new Lotto(numbersOutOfRange))
                .isInstanceOf(LottoOutOfRangeException.class);
    }

    static Stream<Arguments> numbersOutOfRange(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,46)),
                Arguments.of(Arrays.asList(0,1,2,3,4,5))
        );
    }
}