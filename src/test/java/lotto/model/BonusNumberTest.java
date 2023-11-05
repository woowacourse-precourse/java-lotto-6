package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 당첨번호_보너스번호_중복_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        WinningNumbers winning = new WinningNumbers(winningNumbers);
        int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> new BonusNumber(winning.getNumbers(), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DUPLICATED.getMessage());
    }

    @Test
    void 당첨번호_보너스번호_올바른입력_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        WinningNumbers winning = new WinningNumbers(winningNumbers);
        int bonusNumber = 7;

        Assertions.assertThatCode(() -> new BonusNumber(winning.getNumbers(), bonusNumber))
                .doesNotThrowAnyException();
    }
}
