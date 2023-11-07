package lotto;

import lotto.domain.Lotto;
import lotto.domain.WonLotto;
import lotto.view.InputCoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest{
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45까지의 숫자가 아닌 값을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "1.2", "a", "55"})
    void createLottoByInvalidValue(String value) {
        assertThatThrownBy(() -> {
            int invalidNumber = Integer.parseInt(value);
            new Lotto(List.of(invalidNumber));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈을 1000원 단위가 아니게 입력하면 예외가 발생한다")
    @Test
    void thousandCoin() {
        assertThatThrownBy(() -> new Lotto(List.of(1111)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 숫자 개수가 6미만이면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void createLottoByNotSixCountOfNumbers(String value) {
        int invalidNumber = Integer.parseInt(value);
        assertThatThrownBy(() -> new Lotto(List.of(invalidNumber)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @DisplayName("돈을 숫자가 아니라 문자거나 소수,음수면 예외가 발생한다")
    @ValueSource(strings = {"abc", "1004", "-1000", "12.334"})
    void createLottoByPurchaseAmountValue(String invalidValue) {
        assertThatThrownBy(() ->
                new InputCoin().convertNumber(List.of(invalidValue).toString()))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWonLottoByDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WonLotto(List.of(1, 2, 3, 4, 5, 6, 7), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 잘못된 번위면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("wrongRangeNumber")
    void createLottoByWrongRangeNumber(List<Integer> numbers, Integer bonusNumber) {
        assertThatThrownBy(() -> new WonLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> wrongRangeNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 46)
        );
    }



}
