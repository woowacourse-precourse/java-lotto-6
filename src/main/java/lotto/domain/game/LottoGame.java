package lotto.domain.game;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningNumber;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;

public class LottoGame {
    private final Lottos lottos;
    private final WinningNumber winningNumber;
    private final LottoNumberGenerator lottoNumberGenerator;

    private LottoGame(final Lottos lottos, final WinningNumber winningNumber, final LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static LottoGame of(final Money money, final WinningNumber winningNumber, final LottoNumberGenerator lottoNumberGenerator) {
        final int lottoCount = money.countLotto();
        final Lottos lottos = Lottos.from(
                IntStream.range(0, lottoCount)
                        .mapToObj(i -> lottoNumberGenerator.generateLottoNumbers())
                        .map(Lotto::new)
                        .toList()
        );

        return new LottoGame(lottos, winningNumber, lottoNumberGenerator);
    }

    public Prizes calculatePrizes() {
        return new Prizes(lottos.calculatePrizes(winningNumber));
    }

    public BigDecimal calculateProfit(final Prizes prizes) {
        BigDecimal totalPrizeMoney = convertToBigDecimal(prizes.getSumOfMoney());
        BigDecimal totalPurchasingCost = convertToBigDecimal(lottos.getPurchasingCost());
        return calculateProfitPercentage(totalPrizeMoney, totalPurchasingCost);
    }

    private BigDecimal convertToBigDecimal(long value) {
        return BigDecimal.valueOf(value);
    }

    private BigDecimal calculateProfitPercentage(BigDecimal totalPrizeMoney, BigDecimal totalPurchasingCost) {
        BigDecimal profitRatio = totalPrizeMoney.divide(totalPurchasingCost, 2, RoundingMode.HALF_UP);
        return convertToPercentage(profitRatio);
    }

    private BigDecimal convertToPercentage(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(100));
    }

}
