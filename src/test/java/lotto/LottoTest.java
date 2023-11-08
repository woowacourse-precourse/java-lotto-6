package lotto;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.service.InputValidator;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호를 오름차순으로 출력한다.")
    @Test
    void testGetAscendingSortedNumbers() {
        List<Integer> numbers = Arrays.asList(26, 42, 4, 12, 5, 31);
        Lotto lotto = new Lotto(numbers);
        List<Integer> sortedNumbers = lotto.getAscendingSortedNumbers();
        List<Integer> expectedSortedNumbers = Arrays.asList(4, 5, 12, 26, 31, 42);
        assertEquals(expectedSortedNumbers, sortedNumbers);
    }

    @DisplayName("당첨 번호 입력이 6개가 아니라면 예외가 발생한다.")
    @Test
    void validateWinningNumbersCount() {
        assertThatThrownBy(() -> new LottoManager(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 1~45 범위가 아니라면 예외가 발생한다.")
    @Test
    void validateWinningNumbersInRange() {
        assertThatThrownBy(() -> new LottoManager(List.of(51, 22, 31, 40, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void validateWinningNumbersDuplicate() {
        assertThatThrownBy(() -> new LottoManager(List.of(22, 22, 31, 40, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}