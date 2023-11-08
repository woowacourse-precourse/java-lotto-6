package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.repository.rank.LottoNumbersPerRank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LotteryTrackerTest {
    LotteryTracker lotteryTracker = LotteryTracker.create();
    static BuyLottoRepository buyLottos = new BuyLottoRepository();
    static WinningLottoRepository winningLottoRepo;

    @BeforeAll
    static void start(){
        // 당첨번호와 보너스 번호 정하기
        Lotto winningLotto = new Lotto(List.of(1, 3, 5, 7, 17, 26));
        int bonusNumer = 15;
        BonusNumber bonusNumber = BonusNumber.from(winningLotto, bonusNumer);
        winningLottoRepo = WinningLottoRepository.of(winningLotto, bonusNumber);

        // 로또 사기
        // 4개 맞음 : 4등
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));
        // 5개 맞음 : 3등
        Lotto buyLotto2 = new Lotto(List.of(1, 26, 4, 5, 7, 17));
        // 5개 맞음 + 보너스점수 맞음 : 2등
        Lotto buyLotto3 = new Lotto(List.of(1, 26, 15, 5, 7, 17));
        buyLottos.add(buyLotto);
        buyLottos.add(buyLotto2);
        buyLottos.add(buyLotto3);
    }

    @DisplayName("산 로또번호가 등수안에 들면 해당등수의 인원수가 증가합니다.")
    @ParameterizedTest
    @CsvSource(value = {"4,1","3,1","2,1"})
    void matching(int rank, int number) {
        // when
        lotteryTracker.matching(buyLottos, winningLottoRepo);

        // then
        assertThat(LottoNumbersPerRank.getNumberBy(rank)).isEqualTo(number);
    }

   @DisplayName("복권으로 번 총수익을 계산합니다")
   @Test
   void calculateTotalRevenue() {
       // when
       // 복권 3개에 2등, 3등, 4등
       lotteryTracker.matching(buyLottos, winningLottoRepo);

       // then
       // 2등(30,000,000) + 3등(1,500,000) + 4등(50,000)
       assertThat(lotteryTracker.calculateTotalRevenue()).isEqualTo(31550000);
   }
}