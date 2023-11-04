package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utils.LottoException.DUPLICATED_LOTTO_NUMBER;
import static lotto.utils.LottoException.LESS_THAN_MINIMUM_LOTTO_NUMBER;
import static lotto.utils.LottoException.MORE_THAN_MAXIMUM_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        Lotto lotto = new Lotto(List.of(5,2,3,6,1,4));
        List<Integer> unmodifiableLotto = lotto.getLotto();

        //then
        assertThat(unmodifiableLotto)
                .isSorted()
                .isSortedAccordingTo(Integer::compareTo);
    }
}