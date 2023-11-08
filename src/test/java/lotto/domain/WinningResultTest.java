package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.constants.LottoReward;
import lotto.generator.LottoNumbersGenerator;
import lotto.generator.LottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @DisplayName("객체 생성이 올바르게 되는지 확인")
    @Test
    void create() {
        WinningResult winningResult = WinningResult.create();
        assertNotNull(winningResult);
    }

    @DisplayName("당첨된 등수의 개수가 올바르게 업데이트 되는지 확인(3등 1개)")
    @Test
    void calWinningResultByThird() {
        WinningResult winningResult = WinningResult.create();
        WinningLotto winningLotto = createWinningLottoByThird();
        Lottos lottos = createLottosByThird();

        winningResult.calWinningResult(winningLotto, lottos);

        int result = winningResult.getWinningCount(LottoReward.getWinningReward(5, false));
        assertEquals(1, result);
    }

    @DisplayName("당첨된 등수의 개수가 올바르게 업데이트 되는지 확인(2등 2개)")
    @Test
    void calWinningResultBySecond() {
        WinningResult winningResult = WinningResult.create();
        WinningLotto winningLotto = createWinningLottoBySecond();
        Lottos lottos = createLottosBySecond();

        winningResult.calWinningResult(winningLotto, lottos);

        int result = winningResult.getWinningCount(LottoReward.getWinningReward(5, true));
        assertEquals(2, result);
    }

    private WinningLotto createWinningLottoByThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7);
        return WinningLotto.create(lotto, bonusNumber);
    }

    private Lottos createLottosByThird() {
        LottoNumbersGenerator lottoNumbersGenerator = mock(LottoNumbersGenerator.class);
        when(lottoNumbersGenerator.generate()).thenReturn(List.of(1, 2, 3, 4, 5, 8));
        LottosGenerator lottosGenerator = LottosGenerator.create(lottoNumbersGenerator);
        TicketCount ticketCount = TicketCount.create(PurchaseAmount.create(1000));
        return Lottos.create(ticketCount, lottosGenerator);
    }

    private WinningLotto createWinningLottoBySecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7);
        return WinningLotto.create(lotto, bonusNumber);
    }

    private Lottos createLottosBySecond() {
        LottoNumbersGenerator lottoNumbersGenerator = mock(LottoNumbersGenerator.class);
        when(lottoNumbersGenerator.generate()).thenReturn(List.of(1, 2, 3, 4, 5, 7))
                .thenReturn(List.of(1, 2, 3, 4, 5, 7));
        LottosGenerator lottosGenerator = LottosGenerator.create(lottoNumbersGenerator);
        TicketCount ticketCount = TicketCount.create(PurchaseAmount.create(2000));
        return Lottos.create(ticketCount, lottosGenerator);
    }

}
