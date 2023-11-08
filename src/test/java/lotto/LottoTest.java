package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("입력 받은 숫자가 정렬이 되는지 확인한다.")
    @Test
    void sortNumbers_ShouldSortTheList() {
        List<Integer> unsortedNumbers = Arrays.asList(4, 2, 1, 3, 5, 6);
        Lotto lotto = new Lotto(new ArrayList<>(unsortedNumbers));

        lotto.sortNumbers();

        List<Integer> sortedNumbers = lotto.getNumbers();
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, sortedNumbers);
    }
}