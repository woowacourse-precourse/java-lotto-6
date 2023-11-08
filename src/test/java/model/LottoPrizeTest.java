package model;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPrizeTest {
    List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(9, 8, 7, 6, 5, 4)));
    LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(List.of(2,3,4,5,6,7), "1");

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

}
