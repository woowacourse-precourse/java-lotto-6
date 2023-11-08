package lotto;

public class LottoService {

    private final LottoIssuer lottoIssuer;
    private final WinningRankCalculator winningRankCalculator;
    private final ProfitRateCalculator profitRateCalculator;

    public LottoService(final LottoIssuer lottoIssuer, final WinningRankCalculator winningRankCalculator, final ProfitRateCalculator profitRateCalculator) {
        this.lottoIssuer = lottoIssuer;
        this.winningRankCalculator = winningRankCalculator;
        this.profitRateCalculator = profitRateCalculator;
    }

    public LottoTickets issue(PaidAmount paidAmount) {
        return lottoIssuer.issue(paidAmount);
    }

    public WinningRankCounts collectWinningRanks(LottoTickets lottoTickets, LottoWinningNumbers lottoWinningNumbers) {
        return lottoTickets.collectWinningRanks(winningRankCalculator, lottoWinningNumbers);
    }

    public ProfitRateDto calculateProfitRate(WinningRankCounts winningRankCounts, PaidAmount paidAmount) {
        double profitRate = profitRateCalculator.calculate(winningRankCounts, paidAmount);
        return ProfitRateDto.from(profitRate);
    }
}
