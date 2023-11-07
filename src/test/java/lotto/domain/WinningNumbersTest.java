package lotto.domain;

import static common.enumtype.ErrorCode.BONUS_NUMBER_ALREADY_REGISTERED;
import static common.enumtype.ErrorCode.WINNING_NUMBERS_CONTAIN_BONUS_NUMBER;
import static common.enumtype.ErrorCode.WINNING_NUMBERS_DUPLICATED;
import static common.enumtype.ErrorCode.WINNING_NUMBERS_INVALID_SIZE;
import static common.enumtype.ResultType.FIFTH_PLACE;
import static common.enumtype.ResultType.FIRST_PLACE;
import static common.enumtype.ResultType.FOURTH_PLACE;
import static common.enumtype.ResultType.NOT_WIN;
import static common.enumtype.ResultType.SECOND_PLACE;
import static common.enumtype.ResultType.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.enumtype.ResultType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 검증")
class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        winningNumbers = new WinningNumbers(numbers);
        winningNumbers.addBonus(new WinningNumber(7));
    }

    @Test
    void 당첨_번호_6개_미만_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 당첨_번호_6개_초과_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 중복된_당첨_번호_에외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_DUPLICATED.getMessage());
    }

    @Test
    void 당첨_번호_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        WinningNumbers result = new WinningNumbers(numbers);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 보너스_번호가_등록된_상태에서_등록_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        WinningNumber winningNumber = new WinningNumber(7);
        winningNumbers.addBonus(winningNumber);

        // when
        // then
        assertThatThrownBy(() -> winningNumbers.addBonus(winningNumber))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(BONUS_NUMBER_ALREADY_REGISTERED.getMessage());
    }

    @Test
    void 당첨_번호와_중복되는_보너스_번호_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        WinningNumber winningNumber = new WinningNumber(1);

        // when
        // then
        assertThatThrownBy(() -> winningNumbers.addBonus(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER.getMessage());
    }

    @Test
    void 로또_번호_미당첨() {
        // given
        List<Integer> lottoNumbers = List.of(6, 7, 8, 9, 10, 11);

        // when
        ResultType result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(NOT_WIN);
    }

    @Test
    void 로또_번호_5등_당첨() {
        // given
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 20, 30, 40),
                List.of(5, 6, 7, 20, 30, 40)
        );

        // when
        List<ResultType> results = new ArrayList<>();
        lottoNumbers.forEach(numbers -> results.add(winningNumbers.matchingResult(numbers)));

        // then
        results.forEach(result -> assertThat(result).isEqualTo(FIFTH_PLACE));
    }

    @Test
    void 로또_번호_4등_당첨() {
        // given
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 30, 40),
                List.of(4, 5, 6, 7, 30, 40)
        );

        // when
        List<ResultType> results = new ArrayList<>();
        lottoNumbers.forEach(numbers -> results.add(winningNumbers.matchingResult(numbers)));

        // then
        results.forEach(result -> assertThat(result).isEqualTo(FOURTH_PLACE));
    }

    @Test
    void 로또_번호_3등_당첨() {
        // given
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 40),
                List.of(3, 4, 5, 6, 7, 40)
        );

        // when
        List<ResultType> results = new ArrayList<>();
        lottoNumbers.forEach(numbers -> results.add(winningNumbers.matchingResult(numbers)));

        // then
        results.forEach(result -> assertThat(result).isEqualTo(THIRD_PLACE));
    }

    @Test
    void 로또_번호_2등_당첨() {
        // given
        List<Integer> lottoNumbers = List.of(2, 3, 4, 5, 6, 7, 40);

        // when
        ResultType result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(SECOND_PLACE);
    }

    @Test
    void 로또_번호_1등_당첨() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6, 40);

        // when
        ResultType result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(FIRST_PLACE);
    }
}
