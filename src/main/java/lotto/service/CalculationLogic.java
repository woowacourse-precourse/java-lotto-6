package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.Number;
import lotto.constant.WinningValues;
import lotto.model.LottoDatas;

public class CalculationLogic {
    private final LottoDatas lottoDatas;

    public CalculationLogic(final LottoDatas lottoDatas) {
        this.lottoDatas = lottoDatas;
    }

    public void calculateFinalPrize() {
        List<Integer> hitCounts = new ArrayList<>();
        hitCounts = compareLottoNumber();
        List<Integer> hitBonusCounts = new ArrayList<>();
        hitBonusCounts = compareBonusNumber();
        saveWinningDatas(hitCounts, hitBonusCounts);
    }

    private List<Integer> compareLottoNumber() {
        List<Integer> hitCounts = new ArrayList<>();
        for (int lottoIndex = 0; lottoIndex < lottoDatas.getLottoPurchaseCount(); lottoIndex++) {
            int hitCount = countHitNumber(lottoDatas.getlottoNumbers(lottoIndex), lottoDatas.getWinningNumbers());
            hitCounts.add(hitCount);
        }
        return hitCounts;
    }

    private List<Integer> compareBonusNumber() {
        List<Integer> bonusCounts = new ArrayList<>();
        for (int lottoIndex = 0; lottoIndex < lottoDatas.getLottoPurchaseCount(); lottoIndex++) {
            int bonusCount = countBonusNumber(lottoDatas.getlottoNumbers(lottoIndex), lottoDatas.getBonusNumber());
            bonusCounts.add(bonusCount);
        }
        return bonusCounts;
    }

    private int countHitNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int hitCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    private int countBonusNumber(List<Integer> lottoNumbers, int countBonusNumber) {
        int hitCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumbers.contains(countBonusNumber)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    private void saveWinningDatas(List<Integer> hitCounts, List<Integer> hitBonusCounts) {
        for (int listIndex = 0; listIndex < hitCounts.size(); listIndex++) {
            int hitCount = hitCounts.get(listIndex);
            int hitBonusCount = hitBonusCounts.get(listIndex);
            compareWinningValues(hitCount, hitBonusCount);
        }
    }

    private void compareWinningValues(int hitCount, int hitBonusCount) {
        WinningValues data = ClassificationWinningData(hitCount, hitBonusCount);
        savaWinningData(data);
    }

    private WinningValues ClassificationWinningData(int hitCount, int hitBonusCount) {
        if (hitBonusCount != 0) {
            if (hitCount == 5) {
                return WinningValues.OUTPUT_LOTTO_2ND_PLACE;
            }
        }
        for (WinningValues winningValue : WinningValues.values()) {
            if (hitCount == winningValue.getWinningCount()) {
                return winningValue;
            }

        }
        return WinningValues.OUTPUT_LOTTO_NOTHING;
    }

    private void savaWinningData(WinningValues data) {
        List<Integer> winningData = new ArrayList<Integer>();
        winningData.add(data.getWinningCount());
        winningData.add(data.getBonusNumberCount());
        winningData.add(data.getWinningAmount());
        lottoDatas.saveWinningData(winningData);
    }

    public double importProfitValue() {
        int totalAmount = 0;
        for (int lottoIndex = 0; lottoIndex < lottoDatas.getLottoPurchaseCount(); lottoIndex++) {
            totalAmount += sumAmount(lottoIndex);
        }
        return calculationProfit(totalAmount, lottoDatas.getLottoPurchaseCount());
    }

    private int sumAmount(int index) {
        return lottoDatas.getWinningData(index).get(Number.WINNING_AMOUNT_INDEX.getMessage());
    }

    private double calculationProfit(int totalAmount, int lottoPurchaseCount) {
        return (double) totalAmount / (lottoPurchaseCount * Number.LOTTO_PRICE.getMessage())
                * Number.PERSENT.getMessage();
    }

    public Map<Integer, Integer> getAllLottoCounts(Map<Integer, Integer> WinningCounts) {
        List<Integer> hitCounts = new ArrayList<>();
        hitCounts = compareLottoNumber();
        List<Integer> hitBonusCounts = new ArrayList<>();
        hitBonusCounts = compareBonusNumber();
        WinningCounts = separatedCounts(WinningCounts, hitCounts, hitBonusCounts);
        return WinningCounts;
    }

    private Map<Integer, Integer> separatedCounts(Map<Integer, Integer> WinningCounts, List<Integer> hitCounts,
                                                  List<Integer> hitBonusCounts) {

        for (int listIndex = 0; listIndex < hitCounts.size(); listIndex++) {
            WinningCounts = addCountToMap(WinningCounts, hitCounts.get(listIndex), hitBonusCounts.get(listIndex));
        }
        return WinningCounts;
    }

    private Map<Integer, Integer> addCountToMap(Map<Integer, Integer> WinningCounts,
                                                int hitCount, int hitBonusCount) {
        if (hitBonusCount != 0) {
            if (hitCount == 5) {
                WinningCounts.put(2, WinningCounts.getOrDefault(2, 0) + 1);
            }
        }
        for (WinningValues winningValue : WinningValues.values()) {
            if (hitCount == winningValue.getWinningCount()) {
                WinningCounts.put(hitCount, WinningCounts.getOrDefault(hitCount, 0) + 1);
                return WinningCounts;
            }
        }
        WinningCounts.put(0, WinningCounts.getOrDefault(0, 0) + 1);
        return WinningCounts;
    }


}
