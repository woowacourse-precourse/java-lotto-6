package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.WinningValues;
import lotto.model.LottoDatas;

public class CalculationLogic {
    private final LottoDatas lottoDatas;

    public CalculationLogic(final LottoDatas lottoDatas) {
        this.lottoDatas = lottoDatas;
    }

    public void calculateFinalPrize() {
        List<Integer> hitCounts = compareLottoNumber();
        List<Integer> hitBonusCounts = compareBonusNumber();
        saveWinningDatas(hitCounts, hitBonusCounts);
    }

    private List<Integer> compareLottoNumber() {
        List<Integer> hitCounts = new ArrayList<>();
        for (int lottoIndex = 0; lottoIndex < lottoDatas.getLottoCount(); lottoIndex++) {
            int hitCount = countHitNumber(lottoDatas.getlottoNumbers(lottoIndex), lottoDatas.getWinningNumbers());
            hitCounts.add(hitCount);
        }
        return hitCounts;
    }

    private List<Integer> compareBonusNumber() {
        List<Integer> bonusCounts = new ArrayList<>();
        for (int lottoIndex = 0; lottoIndex < lottoDatas.getLottoCount(); lottoIndex++) {
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
        List<Integer> winningDatasList = new ArrayList<>();
        WinningValues data = ClassificationWinningData(hitCount, hitBonusCount);
        savaWinningData(data);
    }

    private WinningValues ClassificationWinningData(int hitCount, int hitBonusCount) {
        if (hitBonusCount != 0) {
            return WinningValues.OUTPUT_LOTTO_2ND_PLACE;
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
        lottoDatas.inputWinningNumber(winningData);
    }


}
