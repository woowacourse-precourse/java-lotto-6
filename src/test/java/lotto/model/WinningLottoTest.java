package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void compareNumbers() {
        List<Integer> numbers = Arrays.asList(10, 6, 22, 35, 1, 24);
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(6, 35, 33, 12, 41, 8), 11);
        assertThat(winningLotto.compareNumbers(lotto)).isEqualTo(2);
    }

    @Test
    void compareCorrectBonusNumber() {
        List<Integer> numbers = Arrays.asList(10, 6, 22, 35, 11, 24);
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(6, 35, 33, 12, 41, 8), 11);
        assertThat(winningLotto.compareBonusNumber(lotto)).isEqualTo(true);
    }

    @Test
    void compareWrongBonusNumber() {
        List<Integer> numbers = Arrays.asList(10, 6, 22, 35, 11, 24);
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(6, 35, 33, 12, 41, 8), 19);
        assertThat(winningLotto.compareBonusNumber(lotto)).isEqualTo(false);
    }
}