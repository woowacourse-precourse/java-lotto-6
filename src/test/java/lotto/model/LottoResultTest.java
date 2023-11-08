package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateLottoResultTest() {
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        RandomLottoGenerator generator = new RandomLottoGenerator();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = LottoTickets.generateRandomLottoTickets(generator, 2);
                    LottoResult lottoResult = LottoResult.calculateLottoResult(winningLotto, lottoTickets);
                    assertEquals(
                            1_502_500.0,
                            lottoResult.getRate(new Money(2000))
                    );
                },
                List.of(2, 3, 4, 5, 6, 7),
                List.of(3, 4, 5, 6, 7, 8)
        );
    }
}
