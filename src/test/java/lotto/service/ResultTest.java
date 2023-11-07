package lotto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResultTest {
    LottoMachine lottoMachine = mock(LottoMachine.class);
    List<Integer> lottoTestNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> lottoTestNumbers2 = Arrays.asList(1, 2, 3, 4, 7, 8);
    List<Integer> winningTestNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

    Lotto winningNumbers;
    BonusNumber bonusNumber;

    @BeforeEach
    void setup() {
        Lotto lotto1 = new Lotto(lottoTestNumbers1);
        Lotto lotto2 = new Lotto(lottoTestNumbers2);

        List<Lotto> lottos = Arrays.asList(lotto1, lotto2);
        when(lottoMachine.getLottos()).thenReturn(lottos);
        when(lottoMachine.getPayment()).thenReturn(new Payment(2000));

        winningNumbers = new Lotto(winningTestNumbers);
        bonusNumber = new BonusNumber(4,winningNumbers);
    }

    @Nested
    @DisplayName("당첨 번호와 보너스 번호의 일치 개수 테스트")
    class ResultCountTest {
        @Test
        void 로또와_일치하는_당첨_번호의_개수를_정확하게_세야한다() {
            Result result = new Result(lottoMachine);
            result.calculateResult(winningNumbers, bonusNumber);
            String expectedResult = "3개 일치 (5,000원) - 1개\n"
                    + "4개 일치 (50,000원) - 0개\n"
                    + "5개 일치 (1,500,000원) - 0개\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                    + "6개 일치 (2,000,000,000원) - 0개";
            assertEquals(expectedResult, result.toString());
        }
    }

    @Test
    void 당첨률_계산_테스트() {
        Result result = new Result(lottoMachine);
        result.calculateResult(winningNumbers, bonusNumber);
        double winningRate = (double) 30005000 / 2000 * 100;
        assertEquals(Math.round(winningRate * 10.0) / 10.0, result.calculateWinningRate());
    }

}