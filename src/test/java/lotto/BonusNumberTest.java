package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinnerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호는 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createDuplicateBonusNumber() {
        WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> new BonusNumber(1, winnerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
