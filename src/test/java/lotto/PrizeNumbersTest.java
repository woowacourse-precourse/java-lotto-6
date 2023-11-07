package lotto;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeNumbersTest {

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외 발생")
    void testBonusNumberIsInLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new prizeNumbers(lotto, bonusNumber);
        });

        assertEquals("보너스 번호는 로또 번호에 포함될 수 없습니다.", exception.getMessage());
    }
}
