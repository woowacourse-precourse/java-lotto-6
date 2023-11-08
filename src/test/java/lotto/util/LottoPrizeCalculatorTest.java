package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeCalculatorTest {

    @Test
    void getResult() {
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusBall.valueOf(45));

        List<Lotto> boughtLottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 45)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 2, 3, 4, 8, 9)),
                Lotto.of(List.of(1, 2, 3, 7, 8, 9)),
                Lotto.of(List.of(21, 22, 23, 24, 25, 26))
        );

        LottoTickets boughtLottoTickets = LottoTickets.of(boughtLottos);

        Map<LottoPrize, Integer> result = LottoPrizeCalculator.getResult(winningLotto, boughtLottoTickets);

        assertAll(
                () -> assertThat(result.keySet().contains(LottoPrize.FIRST_PRIZE)),
                () -> assertThat(result.keySet().contains(LottoPrize.SECOND_PRIZE)),
                () -> assertThat(result.keySet().contains(LottoPrize.THIRD_PRIZE)),
                () -> assertThat(result.keySet().contains(LottoPrize.FORTH_PRIZE)),
                () -> assertThat(result.keySet().contains(LottoPrize.FIFTH_PRIZE)),
                () -> assertThat(result.keySet().contains(LottoPrize.NONE))
        );
    }

    @Test
    void getProfitRate() {

        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusBall.valueOf(7));

        List<Lotto> boughtLottos = List.of(
                Lotto.of(List.of(8, 21, 23, 41, 42, 43)),
                Lotto.of(List.of(3, 5, 11, 16, 32, 38)),
                Lotto.of(List.of(7, 11, 16, 35, 36, 44)),
                Lotto.of(List.of(1, 8, 11, 31, 41, 42)),
                Lotto.of(List.of(13, 14, 16, 38, 42, 45)),
                Lotto.of(List.of(7, 11, 30, 40, 42, 43)),
                Lotto.of(List.of(2, 13, 22, 32, 38, 45)),
                Lotto.of(List.of(1, 3, 5, 14, 22, 45))
        );

        LottoTickets boughtLottoTickets = LottoTickets.of(boughtLottos);

        Map<LottoPrize, Integer> result = LottoPrizeCalculator.getResult(winningLotto, boughtLottoTickets);

        String profitRate = LottoPrizeCalculator.getProfitRate(result, boughtLottoTickets);
        System.out.println("profitRate = " + profitRate);

        assertThat(profitRate).contains("62.5");
    }

}