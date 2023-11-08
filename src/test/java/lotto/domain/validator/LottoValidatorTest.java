package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @DisplayName("로또 번호가 6개가 아닌 경우 예외 발생")
    @Test
    void should_Throw_Exception_When_Numbers_Size_Is_Not_Six() {
        // given
        List<Integer> numbers1 = List.of(1, 2, 4);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.verifyNumbersSize(numbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT.get());

        assertThatThrownBy(() ->
                LottoValidator.verifyNumbersSize(numbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT.get());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,5", "1,1,2,2,3,3"})
    void should_Throw_Exception_When_Numbers_Contain_Duplicates(String str) {
        // given
        List<Integer> numbers = Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .toList();

        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.verifyNoDuplication(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_NUMBERS.get());
    }

    @DisplayName("로또 번호가 1에서 45 사이의 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"200,62,79,454,343,273", "50,60,900,80,90,100"})
    void should_Throw_Exception_When_Number_Is_Out_Of_Range(String str) {
        // given
        List<Integer> numbers = Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .toList();
        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.verifyLottoNumberRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_OUT_OF_RANGE.get());
    }

    @DisplayName("보너스 번호가 1에서 45 사이의 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 50, 100})
    void should_Throw_Exception_When_BonusNumber_Is_Out_Of_Range(int number) {
        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.verifyBonusNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.get());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외 발생")
    @Test
    void should_Throw_Exception_When_BonusNumber_Is_Duplicate_With_WinningNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = Lotto.from(numbers);

        BonusNumber bonusNumber = BonusNumber.from(1);

        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.verifyBonusIsNotContainWinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER.get());
    }
}