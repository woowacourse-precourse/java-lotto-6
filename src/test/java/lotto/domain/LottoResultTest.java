package lotto.domain;

import lotto.domain.constant.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("로또 결과에 대해 상금과 등수를 가진 상수로 반환한다.")
    @Test
    void getWinningResult() {
        List<List<Integer>> generateNumbers = List.of(List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(5, 6, 7, 8, 9, 10));
        LottoTickets lottoTickets = LottoTickets.generateLottos(generateNumbers);

        WinningLotto winningLotto = WinningLotto
                .createWinningLotto(List.of("1", "2", "3", "4", "5", "6"), "7");

        LottoResult lottoResult = LottoResult.createLottoResult(winningLotto, lottoTickets);

        Map<LottoPrize, Integer> lottoPrizes = lottoResult.getLottoPrizesHistory();

        assertThat(lottoPrizes.size()).isEqualTo(LottoPrize.values().length - 1);
        assertThat(lottoPrizes.get(LottoPrize.FIRST)).isEqualTo(1);
        assertThat(lottoPrizes.get(LottoPrize.SECOND)).isEqualTo(1);
        assertThat(lottoPrizes.get(LottoPrize.FORTH)).isEqualTo(0);
        assertThat(lottoPrizes.get(LottoPrize.LOSING)).isEqualTo(null);
    }

    @DisplayName("로또의 수익률을 반환한다. 100% 이상")
    @Test
    void calculateReturnOnInvestment_over100() {
        List<List<Integer>> generateNumbers = List.of(List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 3, 4, 5, 6, 7),
                List.of(5, 6, 7, 8, 9, 10));

        LottoTickets lottoTickets = LottoTickets.generateLottos(generateNumbers);

        WinningLotto winningLotto = WinningLotto
                .createWinningLotto(List.of("1", "2", "3", "4", "5", "6"), "7");

        Money money = Money.of("3000");

        LottoResult lottoResult = LottoResult.createLottoResult(winningLotto, lottoTickets);

        double calculateProfit = lottoResult.calculateProfitOnInvestment(money);

        assertThat(calculateProfit).isEqualTo(1666.7);
    }

    @DisplayName("로또의 수익률을 반환한다. 100% 미만")
    @Test
    void calculateReturnOnInvestment_under100() {
        List<Integer> numbers = List.of(4, 5, 6, 15, 16, 17);
        List<Integer> numbers1 = List.of(12, 13, 14, 15, 16, 17);
        List<Integer> numbers2 = List.of(15, 16, 17, 18, 19, 20);

        LottoTickets lottoTickets = LottoTickets.generateLottos(List.of(numbers, numbers1,
                numbers2, numbers2, numbers2, numbers2));

        WinningLotto winningLotto = WinningLotto
                .createWinningLotto(List.of("1", "2", "3", "4", "5", "6"), "7");

        Money money = Money.of("6000");

        LottoResult lottoResult = LottoResult.createLottoResult(winningLotto, lottoTickets);

        double calculateProfit = lottoResult.calculateProfitOnInvestment(money);

        Assertions.assertThat(calculateProfit).isEqualTo(83.3);
    }
}