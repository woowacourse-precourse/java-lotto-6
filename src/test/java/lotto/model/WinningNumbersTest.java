package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 당첨번호_6개_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6,7));

        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LACK_NUMBER_COUNT.getMessage());
    }

    @Test
    void 당첨번호_범위_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,53,300,4,5,6));

        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_NOT_INRANGE.getMessage());
    }

    @Test
    void 당첨번호_중복_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,5));

        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DUPLICATED.getMessage());
    }
}
