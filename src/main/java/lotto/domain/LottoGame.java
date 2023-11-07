package lotto.domain;

import static lotto.util.Constants.LOTTO_ONE_GAME_PRICE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final BigDecimal HUNDRED = new BigDecimal("100");

    private final Lotto winnerLotto;
    private final BonusNumber bonusNumber;
    private final Map<WinningRank, Integer> rankResult;
    private BigDecimal resultRate;

    private LottoGame(Lotto winnerLotto, BonusNumber bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
        this.rankResult = new EnumMap<>(WinningRank.class);
        this.resultRate = BigDecimal.ZERO;
    }

    public static LottoGame by(Lotto winnerLotto, BonusNumber bonusNumber) {
        return new LottoGame(winnerLotto, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winnerLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public Map<WinningRank, Integer> calculateRanking(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            WinningRank rank = calculateLottoRank(this, lotto);
            rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
        }
        return rankResult;
    }

    private WinningRank calculateLottoRank(LottoGame lottoGame, Lotto lotto) {
        LottoResult lottoResult = new LottoResult(lottoGame, lotto);
        return lottoResult.calculateRank();
    }

    public BigDecimal calculateResultRate(LottoTicket lottoTicket) {
        BigDecimal ticketBudget = new BigDecimal(lottoTicket.getTicketCount() * LOTTO_ONE_GAME_PRICE);

        if (ticketBudget.equals(BigDecimal.ZERO)) {
            return resultRate;
        }
        BigDecimal totalPrize = calculateTotalPrize(lottoTicket);
        resultRate = calculateResultRate(totalPrize, ticketBudget);

        return resultRate;
    }

    private BigDecimal calculateTotalPrize(LottoTicket lottoTicket) {
        return lottoTicket.getLottos().stream()
                .map(lotto -> calculateLottoRank(this, lotto).getPrize())
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateResultRate(BigDecimal totalPrize, BigDecimal ticketBudget) {
        return totalPrize.multiply(HUNDRED)
                .divide(ticketBudget, 1, RoundingMode.HALF_EVEN);
    }
}
