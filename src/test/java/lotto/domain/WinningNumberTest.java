package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


class WinningNumberTest {

    @ParameterizedTest
    @CsvSource({"0,2,3,4,5,6", "1,2,3,45,47,48", "1,1,2,2,3,3"})
    @DisplayName("로또 당첨번호 생성 예외 테스트")
    void createWinningNumberExceptionTest(int num1, int num2, int num3, int num4, int num5, int num6) {
        //given
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);

        //when then
        Assertions.assertThatThrownBy(() -> new WinningNumber(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 초과 번호 입력시 예외 테스트")
    void numberSizeExceptionTest1() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //when then
        Assertions.assertThatThrownBy(() -> new WinningNumber(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 미만 번호 입력시 예외 테스트")
    void numberSizeExceptionTest2() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //when then
        Assertions.assertThatThrownBy(() -> new WinningNumber(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}