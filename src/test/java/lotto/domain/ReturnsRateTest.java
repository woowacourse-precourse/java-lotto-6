package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.generator.LottoNumbersGenerator;
import lotto.generator.LottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReturnsRateTest {

    @DisplayName("3등이 두번 당첨된 상황일때 올바른 수익률로 생성 되는지 ")
    @Test
    void createByRate300_000() {
        WinningResult winningResult = WinningResult.create();
        WinningLotto winningLotto = createWinningLottoByThird();
        Lottos lottos = createLottosByThird();

        winningResult.calWinningResult(winningLotto, lottos);
        ReturnsRate returnsRate = ReturnsRate.create(PurchaseAmount.create(1000), winningResult);
        assertEquals(150_000, returnsRate.toDto().returnsRate());
        ;

    }

    private WinningLotto createWinningLottoByThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7);
        return WinningLotto.create(lotto, bonusNumber);
    }

    private Lottos createLottosByThird() {
        LottoNumbersGenerator lottoNumbersGenerator = mock(LottoNumbersGenerator.class);
        when(lottoNumbersGenerator.generate()).thenReturn(List.of(1, 2, 3, 4, 5, 8))
                .thenReturn(List.of(1, 2, 3, 4, 5, 8));
        LottosGenerator lottosGenerator = LottosGenerator.create(lottoNumbersGenerator);
        TicketCount ticketCount = TicketCount.create(PurchaseAmount.create(1000));
        return Lottos.create(ticketCount, lottosGenerator);
    }


}
