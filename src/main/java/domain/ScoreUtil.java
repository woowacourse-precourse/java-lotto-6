package domain;

import dto.Lotto;
import java.util.List;
import java.util.Map;

public class ScoreUtil {
    public static int hasFiveAndbonusNumber;
    private Map<Integer, Integer> initLottoScore() {
        Map<Integer, Integer> lottoScore = new java.util.HashMap<>(Map.of(
                0, 0,
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0
        ));
        return lottoScore;
    }
    private int checkSameNumberCnt(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int sameNumberCnt = 0;
        for (int j = 0; j < winningNumbers.size(); j++) {
            if (lottoNumbers.contains(winningNumbers.get(j))) {
                sameNumberCnt++;
            }
        }
        return sameNumberCnt;
    }

    public Map<Integer, Integer> updateScore(int lottoCnt, List<Lotto> lottos, int bonusNumber, List<Integer> winningNumbers) {
        Map<Integer, Integer> lottoScore = initLottoScore();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = lottos.get(i);
            List<Integer> lottoNumbers = lotto.getLottoNumbers();

            int sameNumberCnt = checkSameNumberCnt(winningNumbers, lottoNumbers);
            if (sameNumberCnt == Constants.MISS_ONE_NUMBER && lottoNumbers.contains(bonusNumber)) {
                hasFiveAndbonusNumber++;
            } else if (sameNumberCnt < Constants.MISS_ONE_NUMBER || sameNumberCnt == Constants.ALL_NUMBER_SAME) {
                lottoScore.put(sameNumberCnt, lottoScore.get(sameNumberCnt) + 1);
            }
        }
        return lottoScore;
    }
}
