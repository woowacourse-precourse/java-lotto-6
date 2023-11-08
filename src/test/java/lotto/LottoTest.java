package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    // 생성자와 getter 테스트
    @DisplayName("맞게 생성 시 생성 후 리스트가 잘 가져와 지는지")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers1")
    void Product_and_GetField(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);
        List<Integer> result = lotto.getNumbers();
        assertThat(result).isEqualTo(numbers);
    }

    static Stream<Arguments> generateLottoNumbers1() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{7, 8, 9, 10, 11, 12}),
                Arguments.of(new int[]{13, 14, 15, 16, 17, 18})
        );
    }

    // validate 메소드 테스트
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // validate_range 메소드 테스트
    @DisplayName("로또 번호에 1~45사이 숫자가 아니면 예외 발생 ")
    @Test
    void createLottoByIsNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 45, 34, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(7, 2, 3, 48, 34, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // range_check 메소드 테스트 : 맞게 입력
    @Test
    public void testRangeCheckWithValidNumber() {
        // 유효한 범위 내의 숫자로 테스트
        assertDoesNotThrow(() -> Lotto.range_check(1));
        assertDoesNotThrow(() -> Lotto.range_check(45));
    }

    // range_check 메소드 테스트 : 안맞게 입력
    @Test
    public void testRangeCheckWithInvalidNumber() {
        // 유효하지 않은 범위의 숫자로 테스트
        assertThrows(IllegalArgumentException.class, () -> Lotto.range_check(0));
        assertThrows(IllegalArgumentException.class, () -> Lotto.range_check(46));
    }

    // validate_duplicate 메소드 테스트
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
