package model;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPrizeTest {
    List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(9, 8, 7, 6, 5, 4)));
    LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers("2,3,4,5,6,7", "1");

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
        assertThat(lottoPrize.compareTo(lottoWinningNumbers, lottos.get(0))).isEqualTo(5);
    }

    @DisplayName("보너스 번호 당첨을 확인하는 테스트")
    @Test
    void lottoPrizeByBonusNumber() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        assertThat(lottoPrize.hasBonusNumber(lottoWinningNumbers, lottos.get(0))).isTrue();
    }

    @DisplayName("처음 당첨된 등수인지 확인하는 테스트")
    @Test
    void lottoPrizeFirstRank() {
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers, lottos);
        assertThat(lottoPrize.hasContain(Prize.of(5, false))).isFalse(); //당첨 번호 5개를 맞추고, 보너스 번호를 못 맞춘 등수는 아직 없음

    }

    @DisplayName("당첨된 적이 있는 등수인지 확인하는 테스트")
    @Test
    void lottoPrizeDuplicationRank() {
        List<Lotto> lottos = List.of(new Lotto(List.of(2, 3, 4, 13, 12, 11)), new Lotto(List.of(2, 3, 4, 9, 10, 11)));
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers,lottos);
        assertThat(lottoPrize.hasContain(Prize.of(3,false))).isTrue(); //당첨 번호 3개를 맞춘 로또가 존재함.
    }

    @DisplayName("로또 당첨 등수와 수량이 올바르게 저장되었는지 확인하는 테스트")
    @Test
    void getLottoPrize(){
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumbers,lottos);
        HashMap prize= lottoPrize.getPrize();
        assertThat(prize.get(Prize.of(5,true))).isEqualTo(1);
    }


}
