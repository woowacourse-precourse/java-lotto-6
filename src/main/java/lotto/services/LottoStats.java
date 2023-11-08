package lotto.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.message.LottoType;

public class LottoStats {
    private final Map<String, Integer> statsMap = new HashMap<>() {{
        put(LottoType.FIVE_THOUSAND.getPrizeCost(), 0);
        put(LottoType.FIFTY_THOUSAND.getPrizeCost(), 0);
        put(LottoType.ONE_HALF_MILLION.getPrizeCost(), 0);
        put(LottoType.THIRTY_MILLION.getPrizeCost(), 0);
        put(LottoType.TWO_HUNDRED_MILLION.getPrizeCost(), 0);
        put(LottoType.EARNING_RATE.getPrizeCost(), 0);
    }};

    double earningRate;

    public Map<String, Integer> calculationOfStats(List<List<Integer>> buyLottoNumbers, List<Integer> prizeNumbers,
                                                   int bonusNumber,
                                                   int amount) {

        for (List<Integer> lottoNumbers : buyLottoNumbers) {
            long matchNumber = lottoNumbers.stream()
                    .filter(prizeNumbers::contains)
                    .count();
            lottoTypeInMatchNumber(lottoNumbers, matchNumber, bonusNumber);
        }

        EarningRate(totalProfit(), amount);

        return statsMap;
    }

    private void EarningRate(double totalProfit, int amount) {
        earningRate = (totalProfit / amount) * 100;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<String, Integer> getStatsMap() {
        return statsMap;
    }

    private void lottoTypeInMatchNumber(List<Integer> lottoNumbers, long matchNumber, int bonusNumber) {
        if (matchNumber == LottoType.ONE_HALF_MILLION.getPrizeOrdinal()) {
            matchBonusNumber(lottoNumbers, bonusNumber);
        }
        if (matchNumber == LottoType.FIVE_THOUSAND.getPrizeOrdinal()) {
            resultRank(LottoType.FIVE_THOUSAND.getPrizeCost());
        }
        if (matchNumber == LottoType.FIFTY_THOUSAND.getPrizeOrdinal()) {
            resultRank(LottoType.FIFTY_THOUSAND.getPrizeCost());
        }
        if (matchNumber == LottoType.TWO_HUNDRED_MILLION.getPrizeOrdinal()) {
            resultRank(LottoType.TWO_HUNDRED_MILLION.getPrizeCost());
        }
    }

    private void resultRank(String prizeCost) {
        statsMap.put(prizeCost, statsMap.get(prizeCost) + 1);
    }

    private void matchBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        boolean matchBonus = lottoNumbers.stream()
                .anyMatch(num -> num == bonusNumber);

        resultBonus(matchBonus);
    }

    private void resultBonus(boolean matchBonus) {
        if (matchBonus) {
            resultRank(LottoType.THIRTY_MILLION.getPrizeCost());
        }
        resultRank(LottoType.TWO_HUNDRED_MILLION.getPrizeCost());
    }

    private double totalProfit() {
        return (multiplyFiveThousand())
                + (multiplyFiftyThousand())
                + (multiplyOneHalfMillion())
                + (multiplyThirtyMillion())
                + (multiplyTwoHundredMillion());
    }

    private double multiplyTwoHundredMillion() {
        String prizeCost = LottoType.TWO_HUNDRED_MILLION.getPrizeCost();
        return (statsMap.get(prizeCost) * Double.parseDouble(prizeCost));
    }

    private double multiplyThirtyMillion() {
        String prizeCost = LottoType.THIRTY_MILLION.getPrizeCost();
        return (statsMap.get(prizeCost) * Double.parseDouble(prizeCost));

    }

    private double multiplyOneHalfMillion() {
        String prizeCost = LottoType.ONE_HALF_MILLION.getPrizeCost();
        return (statsMap.get(prizeCost) * Double.parseDouble(prizeCost));
    }

    private double multiplyFiftyThousand() {
        String prizeCost = LottoType.FIFTY_THOUSAND.getPrizeCost();
        return (statsMap.get(prizeCost) * Double.parseDouble(prizeCost));

    }

    private double multiplyFiveThousand() {
        String prizeCost = LottoType.FIVE_THOUSAND.getPrizeCost();
        return (statsMap.get(prizeCost) * Double.parseDouble(prizeCost));
    }
}
