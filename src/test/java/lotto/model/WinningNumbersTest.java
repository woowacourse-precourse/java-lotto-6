package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    private Lotto mainNumbers;

    @BeforeEach
    void setUp() {
        mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호가_1에서_45_사이가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(mainNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(mainNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_6개와_보너스번호_1개를_HashSet에_모은다() {
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, 10);

        HashSet<Integer> result = winningNumbers.assembleWinningNumbers();

        assertThat(result).hasSize(7);
        assertThat(result).contains(1, 2, 3, 4, 5, 6, 10);
    }
}
