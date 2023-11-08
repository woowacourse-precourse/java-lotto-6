package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultServiceTest {

    ResultService resultService = new ResultService();
    LotteryTracker lotteryTracker = LotteryTracker.create();
    BuyLottoRepository buyLottos = new BuyLottoRepository();
    WinningLottoRepository winningLottoRepo;

    @BeforeEach
    void start(){
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
        lotteryTracker.matching(buyLottos,winningLottoRepo);
    }

    @Test
    @DisplayName("로또로 벌어들인 수익률을 계산해줍니다.")
    void calculateRateOfReturn() {
        // when
        // 복권을 10000개 샀고 2등, 3등, 4등이 한개씩 나왔다고 가정
        int purchaseCount= 10000;
        // then
        assertThat(resultService.calculateRateOfReturn(10000))
                .isEqualTo(315.5);
    }
}