package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeServiceTest {

    @Test
    @DisplayName("생성된 모든 로또 번호들과 당첨 번호를 비교하여 당첨 등수 개수가 잘 업데이트 되는지 테스트")
    void testCreateLottoPrize() {
        int bonusNumber = 6;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 12);
        Lotto firstLotto = Lotto.create(numbers);
        Lotto secondLotto = Lotto.create(numbers);
        Lottos lottos = new Lottos();
        LottoPrizeService lottoPrizeService = new LottoPrizeService();

        lottos.save(firstLotto);
        lottos.save(secondLotto);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.create(winningNumbers, bonusNumber);
        LottoPrize lottoPrize = lottoPrizeService.createLottoPrize(lottos, lottoWinningNumbers);

        assertThat(lottoPrize.getSecondRankCount()).isEqualTo(2);
    }
}