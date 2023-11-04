package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    @DisplayName("당첨 결과를 확인하는 기능")
    void obtainGrade() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto drawLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Integer bonus = 1;
        LottoDrawResult lottoDrawResult = new LottoDrawResult(drawLotto, bonus);

        Assertions.assertThat(Calculator.checkWinning(lotto, lottoDrawResult)).isEqualTo(Grade.SECOND);
    }

}