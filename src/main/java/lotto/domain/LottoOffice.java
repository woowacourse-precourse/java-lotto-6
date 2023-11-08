package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoOffice {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
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
            int rightBonus = compareBonusNumber(lotto.getNumbers(), bonusNumber);
            saveResult(rightNumber, rightBonus);
        }
        return result;
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public double getYield(int purchaseAmount) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += (rank.getWinningAmount() * result.get(rank));
        }
        return sum / purchaseAmount * PERCENT;
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

    private int compareBonusNumber(List<Integer> lottoNumbers, int bonus) {
        if (lottoNumbers.contains(bonus)) return COUNT_ONE;
        return COUNT_ZERO;
    }

    private void initSetting() {
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
    }
}
