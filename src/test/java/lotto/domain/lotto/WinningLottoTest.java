package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.exception.DuplicateBonusNumberException;
import lotto.domain.lotto.exception.DuplicateLottoNumberException;
import lotto.domain.lotto.exception.InvalidLottoLengthException;
import lotto.domain.lotto.exception.InvalidLottoNumberException;
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

    @DisplayName("당첨 번호와 일치하는 로또 번호 및 보너스 번호 개수에 따라 다른 LottoPrize 반환")
    @Test
    void draw_byMatchingCountAndBonusNumber_shouldReturnAppropriateLottoPrize() {
        // given
        final List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 7);
        final List<Integer> numbers3 = List.of(1, 2, 3, 4, 5, 10);
        final List<Integer> numbers4 = List.of(1, 2, 3, 4, 10, 11);
        final List<Integer> numbers5 = List.of(1, 2, 3, 10, 11, 12);
        final List<Integer> numbers6 = List.of(1, 2, 10, 11, 12, 13);
        final List<Integer> numbers7 = List.of(1, 10, 11, 12, 13, 14);
        final List<Integer> numbers8 = List.of(10, 11, 12, 13, 14, 15);
        final int bonusNumber = 7;

        final Lotto lotto1 = new Lotto(numbers1);
        final Lotto lotto2 = new Lotto(numbers2);
        final Lotto lotto3 = new Lotto(numbers3);
        final Lotto lotto4 = new Lotto(numbers4);
        final Lotto lotto5 = new Lotto(numbers5);
        final Lotto lotto6 = new Lotto(numbers6);
        final Lotto lotto7 = new Lotto(numbers7);
        final Lotto lotto8 = new Lotto(numbers8);
        final WinningLotto winningLotto = new WinningLotto(numbers1, bonusNumber);

        // when
        final LottoPrize lottoPrize1 = winningLotto.draw(lotto1);
        final LottoPrize lottoPrize2 = winningLotto.draw(lotto2);
        final LottoPrize lottoPrize3 = winningLotto.draw(lotto3);
        final LottoPrize lottoPrize4 = winningLotto.draw(lotto4);
        final LottoPrize lottoPrize5 = winningLotto.draw(lotto5);
        final LottoPrize lottoPrize6 = winningLotto.draw(lotto6);
        final LottoPrize lottoPrize7 = winningLotto.draw(lotto7);
        final LottoPrize lottoPrize8 = winningLotto.draw(lotto8);

        // then
        assertThat(lottoPrize1).isEqualTo(LottoPrize.FIRST);
        assertThat(lottoPrize2).isEqualTo(LottoPrize.SECOND);
        assertThat(lottoPrize3).isEqualTo(LottoPrize.THIRD);
        assertThat(lottoPrize4).isEqualTo(LottoPrize.FOURTH);
        assertThat(lottoPrize5).isEqualTo(LottoPrize.FIFTH);
        assertThat(lottoPrize6).isEqualTo(LottoPrize.X);
        assertThat(lottoPrize7).isEqualTo(LottoPrize.X);
        assertThat(lottoPrize8).isEqualTo(LottoPrize.X);
    }


}