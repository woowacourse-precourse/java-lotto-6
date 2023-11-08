package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class WinningNumbersTest {
    private static final String REGEX = ",";
    private static final List<Integer> DEFAULT_WINNING_NUMBERS = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final Integer DEFAULT_BONUS_NUMBER = 7;

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,8", "1,2,3,4,5", "1,2,3"})
    public void 당첨_번호가_6개가_아니면_예외를_발생시킨다(String winningNumbers) {
        // given
        List<Integer> numbers = convertInput(winningNumbers);

        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(numbers, DEFAULT_BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,4,5:6"}, delimiterString = ":")
    public void 당첨_번호와_보너스_번호를_모두_포함하여_중복되는_숫자가_있으면_예외를_발생시킨다(String winningNumbers, Integer bonusNumber) {
        // given
        List<Integer> numbers = convertInput(winningNumbers);

        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7"}, delimiterString = ":")
    public void 당첨_번호와_보너스_번호의_조건이_올바르면_WinnningNumbers_객체를_생성할_수_있다(String winningNumbers, Integer bonusNumber) {
        // given
        List<Integer> numbers = convertInput(winningNumbers);

        // when
        WinningNumbers actual = new WinningNumbers(numbers, bonusNumber);

        // then
        Assertions.assertThat(actual).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD",
            "1,2,3,4,44,45:FOURTH", "1,2,3,43,44,45:FIFTH", "1,2,42,43,44,45:BLANK"},
            delimiterString = ":")
    public void WinningNumbers_객체는_LottoTicket과_비교를_통해_올바른_Rank를_생성할_수_있다(String lottoNumbers, Rank expected) {
        // given
        List<Integer> numbers = convertInput(lottoNumbers);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        WinningNumbers winningNumbers = new WinningNumbers(DEFAULT_WINNING_NUMBERS, DEFAULT_BONUS_NUMBER);

        // when
        Rank actual = winningNumbers.getRank(lottoTicket);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private List<Integer> convertInput(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}