package lotto.domain;

import static common.ErrorCode.BONUS_NUMBER_ALREADY_REGISTERED;
import static common.ErrorCode.WINNING_NUMBERS_CONTAIN_BONUS_NUMBER;
import static common.ErrorCode.WINNING_NUMBERS_DUPLICATED;
import static common.ErrorCode.WINNING_NUMBERS_INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 로또_번호_당첨_번호_비교_0개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(7, 8, 9, 10, 11, 12);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 로또_번호_당첨_번호_비교_1개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(6, 7, 8, 9, 10, 11);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 로또_번호_당첨_번호_비교_2개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(5, 6, 7, 8, 9, 10);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 로또_번호_당첨_번호_비교_3개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(4, 5, 6, 7, 8, 9);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 로또_번호_당첨_번호_비교_4개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(3, 4, 5, 6, 7, 8);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 로또_번호_당첨_번호_비교_5개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(2, 3, 4, 5, 6, 7);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 로또_번호_당첨_번호_비교_6개_매칭() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        int result = winningNumbers.matchingResult(lottoNumbers);

        // then
        assertThat(result).isEqualTo(6);
    }
}
