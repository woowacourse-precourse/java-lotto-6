package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoWinCategory;
import lotto.dto.LottoPurchase;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoDraw;
import lotto.model.LottoTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticTest {

    @DisplayName("번호가 6개 일치한다면 결과로 1등을 반환한다.")
    @Test
    void winFirstPrize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        Lotto purchasedLotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        // when
        LottoWinCategory winning = lottoDraw.getWinning(purchasedLotto);

        // then
        assertThat(winning).isEqualTo(LottoWinCategory.FIRST_PRIZE);
    }



    @DisplayName("번호 5개와 보너스번호가 일치한다면 결과로 2등을 반환한다.")
    @Test
    void winThirdPrize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto purchasedLotto = new Lotto(lottoNumbers);

        // when
        LottoWinCategory winning = lottoDraw.getWinning(purchasedLotto);

        // then
        assertThat(winning).isEqualTo(LottoWinCategory.SECOND_PRIZE);
    }

    @DisplayName("번호가 5개 일치한다면 결과로 3등을 반환한다.")
    @Test
    void winSecondPrize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 10);
        Lotto purchasedLotto = new Lotto(lottoNumbers);

        // when
        LottoWinCategory winning = lottoDraw.getWinning(purchasedLotto);
        System.out.println(lottoNumbers.contains(bonusNumber.getNumber()));
        // then
        assertThat(winning).isEqualTo(LottoWinCategory.THIRD_PRIZE);
    }

    @DisplayName("번호가 4개 일치한다면 결과로 4등을 반환한다.")
    @Test
    void winFourthPrize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 10, 11);
        Lotto purchasedLotto = new Lotto(lottoNumbers);

        // when
        LottoWinCategory winning = lottoDraw.getWinning(purchasedLotto);

        // then
        assertThat(winning).isEqualTo(LottoWinCategory.FOURTH_PRIZE);
    }

    @DisplayName("번호가 3개 일치한다면 결과로 5등을 반환한다.")
    @Test
    void winFifthPrize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        List<Integer> lottoNumbers = List.of(1, 2, 3, 10, 11, 12);
        Lotto purchasedLotto = new Lotto(lottoNumbers);

        // when
        LottoWinCategory winning = lottoDraw.getWinning(purchasedLotto);

        // then
        assertThat(winning).isEqualTo(LottoWinCategory.FIFTH_PRIZE);
    }

    @DisplayName("번호가 2개 이하로 일치한다면 결과로 꽝을 반환한다.")
    @Test
    void winNoPrize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        List<Integer> lottoNumbers = List.of(1, 2, 10, 11, 12, 13);
        Lotto purchasedLotto = new Lotto(lottoNumbers);

        // when
        LottoWinCategory winning = lottoDraw.getWinning(purchasedLotto);

        // then
        assertThat(winning).isEqualTo(LottoWinCategory.NO_PRIZE);
    }

    @DisplayName("구입한 로또를 당첨 등급 기준으로 분류해 개수를 반환한다.")
    @Test
    void classifiedBasedOnWinningGrade() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> numbers4 = List.of(1, 2, 3, 4, 8, 9);
        List<Integer> numbers5 = List.of(1, 2, 3, 8, 9, 10);

        List<Lotto> purchasedLotto = List.of(
                new Lotto(numbers1),
                new Lotto(numbers2),
                new Lotto(numbers3),
                new Lotto(numbers4),
                new Lotto(numbers5)
        );
        LottoTicket lottoTicket = LottoTicket.of(purchasedLotto, 5, 5 * LottoPurchase.LOTTO_PRICE);

        // when
        Map<LottoWinCategory, Integer> winnings = lottoDraw.getWinnings(lottoTicket);

        // then
        assertThat(winnings).containsEntry(LottoWinCategory.FIRST_PRIZE, 1);
        assertThat(winnings).containsEntry(LottoWinCategory.SECOND_PRIZE, 1);
        assertThat(winnings).containsEntry(LottoWinCategory.THIRD_PRIZE, 1);
        assertThat(winnings).containsEntry(LottoWinCategory.FOURTH_PRIZE, 1);
        assertThat(winnings).containsEntry(LottoWinCategory.FIFTH_PRIZE, 1);
    }

    @DisplayName("구입한 로또의 수익 금액과 로또 구매 금액을 이용해 수익률을 계산한다")
    @Test
    void calculateWinningRate() {
        // given
        Map<LottoWinCategory, Integer> winningResult = Map.of(
                LottoWinCategory.FIRST_PRIZE, 0,
                LottoWinCategory.SECOND_PRIZE, 0,
                LottoWinCategory.THIRD_PRIZE, 0,
                LottoWinCategory.FOURTH_PRIZE, 0,
                LottoWinCategory.FIFTH_PRIZE, 5
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.of(7);
        Lotto lotto = new Lotto(winningNumbers);
        LottoDraw lottoDraw = LottoDraw.of(lotto, bonusNumber);

        int totalPurchaseAmount = 5 * LottoPurchase.LOTTO_PRICE;

        // when
        double winningRate = lottoDraw.getWinningRate(winningResult, totalPurchaseAmount);

        System.out.println(winningRate);
        // then
        assertThat(winningRate).isCloseTo(
                (double) ((5 * LottoWinCategory.FIFTH_PRIZE.getPrize()) / totalPurchaseAmount) * 100,
                Assertions.within(0.01)
        );
    }

}
