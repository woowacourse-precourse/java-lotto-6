package lotto;

import lotto.domain.WinningNumber;
import lotto.validator.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("당첨 번호 입력 테스트")
public class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외를 던지는 지 테스트")
    void 당첨번호_개수_테스트() {
        // given
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(6);
        winningNumber.add(7);
        // when,then
        Assertions.assertThatThrownBy(
                () -> new WinningNumber(winningNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("콤마 형식이 틀렸을 때 예외를 던지는 지 테스트")
    @ValueSource(strings = "1,2,3,,4,5")
    void 콤마_형식_테스트(String input) {
        Assertions.assertThatThrownBy(
                () -> Validator.checkWinningNumberForm(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호에 문자을 입력하였을 경우 예외를 던지는 지 테스트")
    void 당첨번호_문자테스트() {
        // given
        List<String> input = List.of("a","1","2","3","4","5");
        // when

        // then
        Assertions.assertThatThrownBy(
                () -> Validator.areAllPrimeNumber(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("중복된 로또 번호 입력했을 때 예외를 던지는 지 테스트")
    @ValueSource(strings = "1,2,3,4,5,5")
    void 중복_입력_테스트(String input) {
        // given
        List<Integer> intList = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // when,then
        Assertions.assertThatThrownBy(
                () -> new WinningNumber(intList)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자 범위 테스트")
    @ValueSource(strings = "1,2,3,4,5,55")
    void 숫자_범위_테스트(String input) {
        // given
        List<Integer> intList = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // when,then
        Assertions.assertThatThrownBy(
                () -> new WinningNumber(intList)
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
