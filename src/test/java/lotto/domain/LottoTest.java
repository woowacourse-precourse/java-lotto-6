package lotto.domain;

import lotto.exception.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoTest {
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

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberUnderOne() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 0);
        //when
        //then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberOverFortyFive() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        //when
        //then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 숫자가 포함되어 있다면 true를 반환한다.")
    @Test
    void containTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.contains(1)).isTrue();
    }

    @DisplayName("로또 번호에 숫자가 포함되어 있지 않다면 false를 반환한다.")
    @Test
    void notContainTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.contains(7)).isFalse();
    }

    @DisplayName("로또 번호가 일치하는 개수를 반환한다.")
    @Test
    void matchCountTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 7);

        //when
        Lotto lotto = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers2);

        //then
        assertThat(lotto.matchCount(lotto2)).isEqualTo(5);
    }
}