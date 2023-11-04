package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.boxed.LottoNumber;
import lotto.domain.lotto.exception.InvalidLottoLengthException;
import lotto.domain.lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class LottoTest {
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

    /**
     * 테스트 목록 1. 로또 생성
     */

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 생성 시, 범위를 벗어나는 숫자가 존재하는 경우 예외 발생")
    @Test
    void Lotto_whenHasNumberOutOfRange_shouldThrowException() {
        // given
        final List<Integer> numbers1 = List.of(0, -1, -2, -3, -4, -5);
        final List<Integer> numbers2 = List.of(46, 47, 48, 49, 50, 51);

        // when
        // then
        assertThatThrownBy(() ->
                new Lotto(numbers1))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(InvalidLottoNumberException.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                new Lotto(numbers2))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(InvalidLottoNumberException.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }

    @DisplayName("로또 생성 시, 번호가 6개 미만일 경우 예외 발생")
    @Test
    void Lotto_withNumbersHasSizeLessThanSix_shouldThrowException() {
        // given
        final List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        final List<Integer> numbers2 = List.of();

        // when
        // then
        assertThatThrownBy(() ->
                new Lotto(numbers1))
                .isInstanceOf(InvalidLottoLengthException.class)
                .hasMessage(InvalidLottoLengthException.INVALID_LOTTO_LENGTH_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                new Lotto(numbers2))
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