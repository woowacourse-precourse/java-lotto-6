package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.boxed.LottoNumber;
import lotto.domain.lotto.exception.DuplicateLottoNumberException;
import lotto.domain.lotto.exception.InvalidLottoLengthException;
import lotto.domain.lotto.exception.InvalidLottoNumberException;
import lotto.exception.DuplicateBonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class WinningLottoTest {

    @DisplayName("1~45 범위의 6개의 숫자와 보너스 번호 1개로 WinningLotto 생성 가능")
    @Test
    void WinningLotto_withNumbersAndBonusNumber_shouldCreateInstance() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        // when
        final WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        // then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("중복되는 로또 숫자가 있을 경우 예외 발생")
    @Test
    void WinningLotto_withDuplicateNumbers_shouldThrowException() {
        // given
        final List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);
        final int bonusNumber = 7;

        // when
        // then
        assertThatThrownBy(() ->
                new WinningLotto(numbers, bonusNumber))
                .isInstanceOf(DuplicateLottoNumberException.class)
                .hasMessage(DuplicateLottoNumberException.DUPLICATE_LOTTO_NUMBER_EXCEPTION);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복일 경우 예외 발생")
    @Test
    void WinningLotto_withDuplicateBonusNumber_shouldThrowException() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 1;

        // when
        // then
        assertThatThrownBy(() ->
                new WinningLotto(numbers, bonusNumber))
                .isInstanceOf(DuplicateBonusNumberException.class)
                .hasMessage(DuplicateBonusNumberException.DUPLICATE_BONUS_NUMBER_EXCEPTION);
    }

    @DisplayName("WinningLotto 생성 시, 범위를 벗어나는 숫자가 존재하는 경우 예외 발생")
    @Test
    void WinningLotto_whenHasNumberOutOfRange_shouldThrowException() {
        // given
        final List<Integer> numbers1 = List.of(0, -1, -2, -3, -4, -5);
        final int bonusNumber1 = 1;
        final List<Integer> numbers2 = List.of(46, 47, 48, 49, 50, 51);
        final int bonusNumber2 = 1;

        // when
        // then
        assertThatThrownBy(() ->
                new WinningLotto(numbers1, bonusNumber1))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(InvalidLottoNumberException.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                new WinningLotto(numbers2, bonusNumber2))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(InvalidLottoNumberException.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }

    @DisplayName("WinningLotto 생성 시, 범위를 벗어나는 보너스 숫자가 존재하는 경우 예외 발생")
    @Test
    void WinningLotto_whenHasBonusNumberOutOfRange_shouldThrowException() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber1 = 0;
        final int bonusNumber2 = 46;

        // when
        // then
        assertThatThrownBy(() ->
                new WinningLotto(numbers, bonusNumber1))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(InvalidLottoNumberException.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                new WinningLotto(numbers, bonusNumber2))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(InvalidLottoNumberException.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }

    @DisplayName("로또 생성 시, 번호가 6개 미만일 경우 예외 발생")
    @Test
    void Lotto_withNumbersHasSizeLessThanSix_shouldThrowException() {
        // given
        final List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        final int bonusNumber = 7;

        final List<Integer> numbers2 = List.of();

        // when
        // then
        assertThatThrownBy(() ->
                new WinningLotto(numbers1, bonusNumber))
                .isInstanceOf(InvalidLottoLengthException.class)
                .hasMessage(InvalidLottoLengthException.INVALID_LOTTO_LENGTH_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                new WinningLotto(numbers2, bonusNumber))
                .isInstanceOf(InvalidLottoLengthException.class)
                .hasMessage(InvalidLottoLengthException.INVALID_LOTTO_LENGTH_EXCEPTION_MESSAGE);
    }

    @DisplayName("1~45 범위에 속하는 로또 번호 6개로 생성 가능")
    @Test
    void Lotto_withSixNumberInRange_shouldCreateInstance() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        final Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("특정 숫자가 로또에 포함 되었는지 확인")
    @Test
    void contains_withNumber_shouldCreateInstance() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        final Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto).isNotNull();
        for (int n : numbers) {
            assertThat(lotto.contains(new LottoNumber(n)));
        }
    }
}