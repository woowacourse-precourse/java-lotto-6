package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumbersTest {
    @Test
    void 범위_내에서_랜덤_숫자를_반환한다() {
        // when
        List<Integer> randomNumbers = LottoNumbers.setLottoNumbers();
        // then
        for (Integer number : randomNumbers){
            assertTrue(isNumberInRange(number));
        }
    }

    private boolean isNumberInRange(int number) {
        return number >= 1 && number <= 45;
    }
}
