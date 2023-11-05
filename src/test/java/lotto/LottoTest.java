package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.ValidateMessage.LOTTO_NUMBER_IS_BETWEEN_1_TO_45;
import static lotto.constant.ValidateMessage.LOTTO_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호는 5개 이하이면 예외가 발생한다.")
    @Test
    void createLottoByLowSize() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 2, 3, 4, 5)));

        //then
        assertTrue(exception.getMessage().contains(LOTTO_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX.message));
    }

    @DisplayName("로또 번호는 6개이고 중복된 숫자가 없어야 한다.")
    @Test
    void createLottoByFitSize() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 숫자는 1 ~ 45 사이 숫자여야 한다.")
    @Test
    void isBetween1And45Test() {
        //given
        List<Integer> isNotBetween1And45 = pickUniqueNumbersInRange(46, 100, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(isNotBetween1And45));

        //then
        assertTrue(exception.getMessage().contains(LOTTO_NUMBER_IS_BETWEEN_1_TO_45.message));
    }

    @DisplayName("로또 숫자는 정렬되서 출력되어야 한다.")
    @Test
    void isSortAscTest() {
        //given
        Lotto lotto = new Lotto(List.of(7, 4, 33, 44, 5, 11));

        //when
        List<Integer> compare = lotto.getNumbers();
        List<Integer> sortedLotto = new ArrayList<>(compare);

        //then
        assertEquals(sortedLotto, lotto.getNumbers());
    }
}