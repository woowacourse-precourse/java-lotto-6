package lotto;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.LottoException.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.LottoException.LESS_THAN_MINIMUM_LOTTO_NUMBER;
import static lotto.exception.LottoException.MORE_THAN_MAXIMUM_LOTTO_NUMBER;
import static lotto.exception.LottoException.NOT_VALID_LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_VALID_LOTTO_NUMBERS_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByLessThanMinimumNumber() {
        //when, then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LESS_THAN_MINIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByMoreThanMaximumNumber() {
        //when, then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MORE_THAN_MAXIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void createLottoByAscendingSort() {
        //given
        Lotto lotto = new Lotto(List.of(5, 2, 3, 6, 1, 4));
        List<Integer> unmodifiableLotto = lotto.getLotto();

        //then
        assertThat(unmodifiableLotto)
                .isSorted()
                .isSortedAccordingTo(Integer::compareTo);
    }

    @DisplayName("로또 번호에 존재하는 숫자면 참을 반환해야 한다.")
    @Test
    void testLottoByExistsNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int target = 5;

        //when
        boolean isExists = lotto.contains(target);

        //then
        assertThat(isExists).isTrue();
    }

    @DisplayName("로또 번호에 존재하지 않는 숫자면 거짓을 반환해야 한다.")
    @Test
    void testLottoByNotExistsNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int target = 10;

        //when
        boolean isExists = lotto.contains(target);

        //then
        assertThat(isExists).isFalse();
    }

    @DisplayName("로또 번호와 같은 숫자의 개수를 반환해야 한다.")
    @Test
    void testCalculateSameNumberCount() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto compareLotto = new Lotto(List.of(5, 9, 4, 1, 2, 10));

        //when
        int matchCount = lotto.calculateSameNumberCount(compareLotto);

        //then
        assertThat(matchCount).isEqualTo(4);
    }
}