package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
