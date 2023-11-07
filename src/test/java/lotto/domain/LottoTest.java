package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("정해진 로또 번호의 개수를 벗어난 값일때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,7})
    void validateSizeRangeThrowExceptionTest(int size) {
        List<Integer> numbers = IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정해진 로또 번호의 개수와 같은 값일때 예외처리 테스트")
    @Test
    void validateSizeRangeDoesNotThrowExceptionTest() {
        int size = 6;
        List<Integer> numbers = IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 중복값이 있을 때 예외처리 테스트")
    @Test
    void validateDuplicationThrowExceptionTest() {
        List<Integer> numbers = Arrays.asList(1,2,3,3,4,5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정해진 범위의 숫자가 아닐 때 예외처리 테스트")
    @Test
    void validateNumberRange() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,79);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}