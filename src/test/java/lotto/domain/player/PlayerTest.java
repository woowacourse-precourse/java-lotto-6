package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.lottoresult.LottoResultsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;
    private Lotto lotto;

    // 테스트 Given 상횡: 10,000을 가진 Player 를 생성
    @BeforeEach
    void initGivenCondition() {
        player = new Player(10000, new LottoBundle());
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("생성한 Player 의 금액 10,000원을 전부 사용하면, 티켓 10장을 발급받는다.")
    @Test
    void playerTest_1() {
        // When
        LottoTicket lottoTicket = player.consumeAllMoneyToLottoTicket();
        // Then
        assertThat(lottoTicket).isEqualTo(new LottoTicket(10));
    }

    @DisplayName("10,000원으로 10장의 티켓을 발급받은 후 로또를 구매하면, 구매한 로또는 10장이다")
    @Test
    void playerTest_2() {
        //when
        player.buyAndSaveRandomLottoWithAllTicket(() -> lotto);
        LottoBundleDto lottoBundleDto = player.makeLottoBundleDto();
        //then
        assertThat(lottoBundleDto.getLottoBundleData().size()).isEqualTo(10);
    }

    @DisplayName("10,000원을 사용한 플레이어는 50,000원 당첨결과를 통해 이익률 500.0을 받을 수 있다.")
    @Test
    void playerTest_ProfitCalculateTest() {
        //given
        player.buyAndSaveRandomLottoWithAllTicket(() -> lotto);

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        BonusNumber winBonusNumber = new BonusNumber(10);
        WinLotto fourthPrizeWinLotto = new WinLotto(winLotto, winBonusNumber);

        LottoResultsRepository lottoResultsRepository = new LottoResultsRepository();
        lottoResultsRepository.updateLottoResultRepository(player.makeLottoBundleDto(), fourthPrizeWinLotto);
        //when
        Profit profit = lottoResultsRepository.calculateProfit(player);
        //then
        assertThat(profit.getProfit()).isEqualTo(500.0);
    }
}
