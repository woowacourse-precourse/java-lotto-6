package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.assertj.core.api.Assertions;

public class ResultTest {
    @Test
    void testCheckBonusNumber() {
        Lotto lotto = new Lotto(List.of(13, 11, 5, 4, 6, 8));
        int bonusNumber = 4;
        Result.checkBonusNumber(lotto, bonusNumber);
        Assertions.assertThat(Result.checkBonusNumber(lotto, bonusNumber)).isTrue();
    }

    @Test
    void testCheckWinNumber() {
        Lotto lotto = new Lotto(List.of(13, 11, 5, 4, 6, 8));
        List<Integer> winNumbers = List.of(5, 4, 6, 11, 12, 13);
        int correctCount = 0;
        Assertions.assertThat(Result.checkWinNumber(lotto, correctCount, winNumbers)).isEqualTo(5);
    }
}
