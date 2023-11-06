package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoOffice {

    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;
    private static final int LEAST_WINNING_COUNT = 3;
    private static final double PERCENT = 100;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoOffice(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initSetting();
    }

    public Map<LottoRank, Integer> getResult(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            int rightNumber = compareNumbers(lotto.getNumbers(), winningNumbers);
            int rightBonus = compareBonusNumber(winningNumbers, bonusNumber);
            saveResult(rightNumber, rightBonus);
        }
        return result;
    }

    private void saveResult(int rightNumber, int bonusNumber) {
        if (rightNumber < LEAST_WINNING_COUNT) return;
        LottoRank rank = LottoRank.findRank(rightNumber, bonusNumber);
        result.put(rank, result.get(rank) + COUNT_ONE);
    }

    private int compareNumbers(List<Integer> lottoNumber, List<Integer> winningNumbers) {
        int cnt = 0;
        for (Integer num : lottoNumber) {
            if (winningNumbers.contains(num)) cnt += COUNT_ONE;
        }
        return cnt;
    }

    private int compareBonusNumber(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) return COUNT_ONE;
        return COUNT_ZERO;
    }

    private void initSetting() {
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
    }
}
