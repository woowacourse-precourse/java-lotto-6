package lotto.domain.game;

import lotto.domain.game.dto.PrizesStatisticsInfo;
import lotto.domain.game.dto.PurchasedLottosInfo;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningNumber;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {
    private final Lottos lottos;
    private final LottoNumberGenerator lottoNumberGenerator;

    private WinningNumber winningNumber;

    private LottoGame(final Lottos lottos, final LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = lottos;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static LottoGame of(final Money money, final LottoNumberGenerator lottoNumberGenerator) {
        final int lottoCount = money.countLotto();
        final Lottos lottos = new Lottos(
                IntStream.range(0, lottoCount)
                        .mapToObj(i -> lottoNumberGenerator.generateLottoNumbers())
                        .map(Lotto::new)
                        .toList()
        );

        return new LottoGame(lottos, lottoNumberGenerator);
    }

    public void updateWinningNumber(final WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public Prizes calculatePrizes() {
        return new Prizes(lottos.calculatePrizes(winningNumber));
    }

    public BigDecimal calculateProfitRate(final Prizes prizes) {
        BigDecimal totalPrizeMoney = convertToBigDecimal(prizes.getSumOfMoney());
        BigDecimal totalPurchasingCost = convertToBigDecimal(lottos.getPurchasingCost());
        return calculateProfitPercentage(totalPrizeMoney, totalPurchasingCost);
    }

    private BigDecimal convertToBigDecimal(long value) {
        return BigDecimal.valueOf(value);
    }

    private BigDecimal calculateProfitPercentage(BigDecimal totalPrizeMoney, BigDecimal totalPurchasingCost) {
        BigDecimal profitRatio = totalPrizeMoney.divide(totalPurchasingCost, 3, RoundingMode.HALF_UP);
        return convertToPercentage(profitRatio);
    }

    private BigDecimal convertToPercentage(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(100));
    }

    public PurchasedLottosInfo getPurchasedLottosInfo() {
        return PurchasedLottosInfo.from(lottos);
    }

    public PrizesStatisticsInfo getPrizesStatisticsInfo(final Prizes prizes) {
        final List<Integer> prizeCounts = calculatePrizeCounts(prizes);
        final BigDecimal profitRate = calculateProfitRate(prizes);

        return new PrizesStatisticsInfo(prizeCounts, profitRate);
    }

    private List<Integer> calculatePrizeCounts(final Prizes prizes) {
        final Map<Prize, Long> prizeCountMap = prizes.prizes().stream()
                .collect(Collectors.groupingBy(prize -> prize, () -> new EnumMap<>(Prize.class), Collectors.counting()));

        return Stream.of(Prize.values())
                .map(prize -> Math.toIntExact(prizeCountMap.getOrDefault(prize, 0L)))
                .toList().subList(0, Prize.values().length - 1);
    }
}
