package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public final class LottoResult {
    private static final String ERROR_RETURN_VALUE = "0%";
    private final Map<LottoRankInfo, Integer> rankResult;

    public LottoResult(Map<LottoRankInfo, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public String getReturnRatio() {
        double totalWinningPrice = getTotalWinningPrice();
        double totalPayPrice = getTotalPayPrice();

        if (totalPayPrice == 0) {
            return ERROR_RETURN_VALUE;
        }
        return convertFormat(totalWinningPrice, totalPayPrice);
    }

    private Long getTotalWinningPrice() {
        List<Long> winningPrices = convertToWinningPrice();

        return winningPrices.stream()
                .reduce(0L, Long::sum);
    }

    private List<Long> convertToWinningPrice() {
        return rankResult.entrySet()
                .stream()
                .map(e -> e.getKey().getRewardPrice() * e.getValue())
                .toList();
    }

    private Long getTotalPayPrice() {
        Integer lottoSize = rankResult.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);

        return (long) (lottoSize * LottoMachine.PRICE_PER_LOTTO);
    }

    private String convertFormat(double totalWinningPrice, double totalPayPrice) {
        DecimalFormat df = new DecimalFormat("#.##%");
        double result = (totalWinningPrice / totalPayPrice);
        return df.format(result);
    }
}
