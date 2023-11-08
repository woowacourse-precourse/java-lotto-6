package model;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPrizeTest {
    List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(9, 8, 7, 6, 5, 4)));
    LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new Lotto(List.of(2,3,4,5,6,7)), "1");

    @DisplayName("하나의 당첨번호와 로또 번호가 일치하는 개수 테스트")
    @Test
    void countOneWinningNumberAndLotto() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        assertThat(lottoPrize.countSameNumber(2, lottos.get(0))).isEqualTo(1);
    }

    @DisplayName("당첨번호와 하나의 로또를 비교하는 테스트")
    @Test
    void compareWinningNumberAndOneLotto() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        assertThat(lottoPrize.compareTo(lottoWinningNumbers.getWinningNumbers(), lottos.get(0))).isEqualTo(5);
    }

    @DisplayName("보너스 번호 당첨을 확인하는 테스트")
    @Test
    void lottoPrizeByBonusNumber() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        assertThat(lottoPrize.hasBonusNumber(lottoWinningNumbers, lottos.get(0))).isTrue();
    }

    @DisplayName("로또 당첨 등수와 수량이 올바르게 저장되었는지 확인하는 테스트")
    @Test
    void getLottoPrize() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        HashMap prize = lottoPrize.getPrizeRepository();
        assertThat(prize.get(Prize.of(5, true))).isEqualTo(1);
    }

    @DisplayName("하나의 등수에서 당첨된 로또 개수만큼 얻을 수 있는 당첨금을 구하는 테스트")
    @Test
    void getPrizeByOneRank() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        assertThat(lottoPrize.calculateOnePrice(Prize.RD3, 2)).isEqualTo(3000000);
    }

    @DisplayName("전체 로또 당첨금을 구하는 테스트")
    @Test
    void getTotalPrize() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        PrizeRepository prizeRepository = new PrizeRepository();
        prizeRepository.add(Prize.ND2);
        prizeRepository.add(Prize.ND2);
        prizeRepository.add(Prize.TH4);
        prizeRepository.add(Prize.TH4);
        prizeRepository.add(Prize.TH4);
        prizeRepository.add(Prize.TH4);
        assertThat(lottoPrize.calculateTotalPrice(prizeRepository)).isEqualTo(60200000);
    }

}
