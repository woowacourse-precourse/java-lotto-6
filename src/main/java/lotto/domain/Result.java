package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.constants.LottoRule;
import lotto.view.contants.OutputMessage;

import java.util.Comparator;
import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> result;

    public Result(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public double calculateLottoRateOfReturn() {
        return (proceeds() / totalBuyLottoAmount()) * 100;
    }

    public double proceeds() {
        return result.entrySet()
                .stream()
                .mapToDouble(result -> result.getKey().getWinningAmount() * result.getValue())
                .sum();
    }

    public double totalBuyLottoAmount() {
        return result.values()
                .stream()
                .mapToDouble(amount -> amount * LottoRule.PRICE.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        result.entrySet().stream()
                .filter(rank -> !rank.getKey().equals(LottoRank.LOSE))
                .sorted(Comparator.comparingInt(rank -> rank.getKey().getWinningAmount()))
                .forEach(
                        rank -> stringBuilder.append(rank.getKey())
                                .append(OutputMessage.BLANK.getValue())
                                .append(OutputMessage.DASH.getValue())
                                .append(OutputMessage.BLANK.getValue())
                                .append(String.format(OutputMessage.COUNT.getValue(), rank.getValue()))
                                .append("\n")
                );
        return stringBuilder.toString();
    }
}
