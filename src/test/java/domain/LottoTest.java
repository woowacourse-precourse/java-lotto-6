package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬 된다.")
    @Test
    void lottoNumberSortByAscendingOrder() {
        List<Integer> numbers = new ArrayList<>(List.of(6,4,3,2,1,5));
        Lotto lotto = new Lotto(numbers);
        Collections.sort(numbers);
        assertEquals(lotto.getNumbers(),numbers);
    }

    @DisplayName("주어진 번호가 로또 번호에 포함되어 있는지 알려준다.")
    @Test
    void showNumberIsInLotto() {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(numbers);

        assertTrue(lotto.isContainNumber(1));
        assertTrue(lotto.isContainNumber(2));
        assertTrue(lotto.isContainNumber(3));
        assertFalse(lotto.isContainNumber(10));
        assertFalse(lotto.isContainNumber(40));
        assertFalse(lotto.isContainNumber(45));
    }
    
}