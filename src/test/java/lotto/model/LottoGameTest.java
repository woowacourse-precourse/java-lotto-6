package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;
import lotto.model.lotto.WinningLotto;
import lotto.model.machine.FixedLottoMachine;
import lotto.model.machine.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    private LottoGame lottoGame;
    private Budget budget;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();

    }

    @DisplayName("로또 게임에서 로또 티켓 생성 테스트")
    @Test
    void generateLottoTicketTest() {
        //given
        budget = new Budget(5000);
        //when
        LottoTicket lottoTicket = lottoGame.generateLottoTicket(budget);
        //then
        assertThat(lottoTicket.getLottoTicketSize()).isEqualTo(5);
    }

    @DisplayName("로또 게임에서 Rank 계산 테스트")
    @Test
    void calculateRankCountTest() {
        //given
        budget = new Budget(1000);
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(7, winningLotto);
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoMachine lottoMachine = new FixedLottoMachine(testNumbers);
        LottoTicket lottoTicket = new LottoTicket(budget, lottoMachine);
        //when
        RankCount rankCount = lottoGame.calculateRankCount(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(rankCount.getCounts(LottoRank.RANK1)).isEqualTo(1);
    }

    @DisplayName("로또 게임에서 수익률 계산 테스트")
    @Test
    void calculateRevenueTest() {
        //given
        RankCount rankCount = new RankCount();
        rankCount.incrementCount(LottoRank.RANK5);
        budget = new Budget(8000);
        //when
        Revenue revenue = lottoGame.calculateRevenue(rankCount, budget);
        //then
        assertThat(revenue.getValue()).isEqualTo("62.5");
    }
}
