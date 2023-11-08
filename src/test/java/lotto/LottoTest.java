package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("중복 기능 테스트")
    void isExistTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertTrue(lotto.isExist(1));
        assertFalse(lotto.isExist(7));
    }

    @Test
    @DisplayName("로또 번호 오름차순 정렬 기능 테스트")
    void sortedNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 1, 2, 3));
        List<Integer> sortedNumbers = lotto.getNumbers();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), sortedNumbers);
    }

    @Test
    @DisplayName("일치 번호 로직 테스트")
    void getCorrectNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(2, 3, 4, 1, 5, 7);
        assertEquals(5, lotto.getCorrectNumbers(winningNumbers));
    }

    @Test
    @DisplayName("로또 넘버 리턴 테스트")
    void getCurrentNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> currentNumbers = lotto.getCurrentNumbers();
        assertThrows(UnsupportedOperationException.class, () -> {
            currentNumbers.add(7);
        });
    }
}
