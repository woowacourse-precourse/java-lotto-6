package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.Grade;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
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

    @Test
    @DisplayName("수익률을 계산하는 기능")
    void calculateReturnRate() {
        List<Lotto> lottos = makeLottos(List.of(4, 5, 6, 7, 8, 9), List.of(14, 15, 16, 17, 18, 19),
                List.of(24, 25, 26, 27, 28, 29));
        LottoDrawResult lottoDrawResult = makeDrawResult(List.of(1, 2, 3, 4, 5, 6), 7);

        Double returnRate = Calculator.returnRate(lottos, lottoDrawResult);
        Assertions.assertThat(returnRate).isGreaterThan(166.5);
        Assertions.assertThat(returnRate).isLessThan(166.7);
    }

    private static List<Lotto> makeLottos(List<Integer>... numbersStock) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < numbersStock.length; i++) {
            Lotto lotto = new Lotto(numbersStock[i]);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static LottoDrawResult makeDrawResult(List<Integer> numbers, Integer bonus) {
        Lotto drawLotto = new Lotto(numbers);
        LottoDrawResult lottoDrawResult = new LottoDrawResult(drawLotto, bonus);
        return lottoDrawResult;
    }
}