package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class LottoResultMap {
    private static final int lottoPrice = 1000;
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    private final Map<LottoResult, Integer> lottoResultMap;

    public LottoResultMap(Map<LottoResult, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
        Arrays.stream(LottoResult.values())
                .forEach(result -> lottoResultMap.put(result, lottoResultMap.getOrDefault(result, 0)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResultMap that = (LottoResultMap) o;
        return Objects.equals(lottoResultMap, that.lottoResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResultMap);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        Arrays.stream(LottoResult.values())
                .filter(result -> result != LottoResult.NONE)
                .forEach(result ->
                        message.append(resultToString(result)));
        message.append(totalProfitMessage());
        return message.toString();
    }

    private String totalProfitMessage() {
        return String.format("총 수익률은 %.2f입니다.", getTotalProfit());
    }

    private String resultToString(LottoResult result) {
        String amountString = formatter.format(result.getMoneyAmount());
        return String.format("%s (%s원) - %개\n",
                result.getDescription(),
                amountString,
                lottoResultMap.get(result));
    }

    private int getLottoCount() {
        return lottoResultMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    private double getTotalProfit() {
        double purchasedMoney = getLottoCount() * lottoPrice;
        return getTotalWinningMoney() / purchasedMoney;
    }

    private long getTotalWinningMoney() {
        return lottoResultMap.entrySet().stream()
                .mapToLong(result -> result.getKey().getMoneyAmount() * result.getValue())
                .sum();
    }


}
