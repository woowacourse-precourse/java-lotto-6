package lotto.service;

import lotto.domain.model.generator.LottoIssuer;
import lotto.domain.model.generator.RandomLottoNumberGenerator;
import lotto.domain.model.lotto.*;
import lotto.domain.model.result.ProfitRateCalculator;
import lotto.domain.model.result.WinningRank;
import lotto.domain.model.result.WinningRankCalculator;
import lotto.domain.model.result.WinningRankCounts;
import lotto.dto.ProfitRateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final Integer PAID_AMOUNT = 4000;
    private static final Integer PRICE_PER_TICKET = 1000;

    private LottoService lottoService;
    private LottoIssuer lottoIssuer;
    private WinningRankCalculator winningRankCalculator;
    private ProfitRateCalculator profitRateCalculator;

    @BeforeEach
    void setUp() {
        lottoIssuer = new LottoIssuer(new RandomLottoNumberGenerator());
        winningRankCalculator = new WinningRankCalculator();
        profitRateCalculator = new ProfitRateCalculator();
        lottoService = new LottoService(lottoIssuer, winningRankCalculator, profitRateCalculator);
    }

    @Test
    void issue() {
        //given
        PaidAmount paidAmount = new PaidAmount(PAID_AMOUNT);
        Integer numberOfLottoTickets = PAID_AMOUNT / PRICE_PER_TICKET;

        //when
        LottoTickets issuedLottos = lottoService.issue(paidAmount);

        //then
        assertThat(issuedLottos.getLottos().size())
                .isEqualTo(numberOfLottoTickets);
    }

    @Test
    void collectWinningRanks() {
        //given
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6)); //1등
        Lotto lotto2 = Lotto.from(List.of(2, 3, 4, 5, 6, 8)); //2등
        Lotto lotto3 = Lotto.from(List.of(2, 3, 4, 5, 6, 7)); //3등
        Lotto winningNumber = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.from(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumber, lottoNumber);
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto1, lotto2, lotto3));

        //when
        WinningRankCounts winningRankCounts = lottoService.collectWinningRanks(lottoTickets, lottoWinningNumbers);

        //then
        assertThat(winningRankCounts.getCount(WinningRank.FIRST)).isEqualTo(1);
        assertThat(winningRankCounts.getCount(WinningRank.SECOND)).isEqualTo(1);
        assertThat(winningRankCounts.getCount(WinningRank.THIRD)).isEqualTo(1);
    }

    @Test
    void calculateProfitRate() {
        //given
        WinningRankCounts winningRankCounts = new WinningRankCounts();
        winningRankCounts.incrementCount(WinningRank.FIRST);
        winningRankCounts.incrementCount(WinningRank.THIRD);
        winningRankCounts.incrementCount(WinningRank.NO_WIN);
        PaidAmount paidAmount = new PaidAmount(3000);

        double expectedRate = (double) (WinningRank.FIRST.getPrize() + WinningRank.THIRD.getPrize()) / 3000 * 100;

        //when
        ProfitRateDto profitRateDto = lottoService.calculateProfitRate(winningRankCounts, paidAmount);

        //then
        assertThat(profitRateDto.getProfitRate())
                .isEqualTo(expectedRate);
    }
}