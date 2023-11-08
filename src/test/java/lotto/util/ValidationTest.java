package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @DisplayName("숫자가 나눠지는지 검증 테스트")
    @Test
    void 숫자_나눠지는지_검증_테스트() {
        int dividend = 4500;
        int divisor = 1000;
        assertThatThrownBy(() -> Validation.validateDivisibleNumber(dividend, divisor))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트가 숫자로만 이루어져 있는지 검증 테스트")
    @Test
    void 리스트_숫자만_있는지_검증_테스트() {
        List<String> list = List.of("1", "2", "3", "a");
        assertThatThrownBy(() -> Validation.validateListNumeric(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 입력이 숫자인지 검증 테스트")
    @Test
    void 문자열_입력_숫자인지_검증_테스트() {
        String input = "a";
        assertThatThrownBy(() -> Validation.validateInputIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 크기 검증 테스트")
    @Test
    void 리스트_크기_검증_테스트() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int size = 6;
        assertThatThrownBy(() -> Validation.validateListSize(list, size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 중복 검증 테스트")
    @Test
    void 리스트_중복_검증_테스트() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> Validation.validateListDuplication(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트에 해당 숫자 있는지 검증 테스트")
    @Test
    void 리스트_해당_숫자_있는지_검증_테스트() {
        List<Integer> list = List.of(1, 2, 3, 4);
        int number = 1;
        assertThatThrownBy(() -> Validation.validateNumberInList(list, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 범위 내에 있는지 검증 테스트")
    @Test
    void 숫자가_범위_내에_있는지_검증_테스트() {
        int number = 100;
        int minNumber = 1;
        int maxNumber = 45;
        assertThatThrownBy(() -> Validation.validateNumberInRange(number, minNumber, maxNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 숫자들이 범위 내에 있는지 검증 테스트")
    @Test
    void 리스트_숫자들_범위_내에_있는지_검증_테스트() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 100);
        int minNumber = 1;
        int maxNumber = 45;
        assertThatThrownBy(() -> Validation.validateListNumbersInRange(list, minNumber, maxNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}