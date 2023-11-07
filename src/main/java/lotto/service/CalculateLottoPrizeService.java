package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.UserLottos;
import lotto.view.ResultView;

public class CalculateLottoPrizeService {
    ResultView resultView = new ResultView();
    private static final int THREE_NUM_CORRECT = 3;
    private static final int FOUR_NUM_CORRECT = 4;
    private static final int FIVE_NUM_CORRECT = 5;
    private static final int SIX_NUM_CORRECT = 6;
    private static final int LOTTO_NUM_AMMOUNT = 6;
    private Map<Prize, Integer> countPrices = new HashMap<>();

    public void calculatePrize(UserLottos userLottos, Lotto lotto) {
        calculateAllLottos(userLottos, lotto);
        resultView.printResult(countPrices);
    }

    public void calculateAllLottos(UserLottos userLottos, Lotto lotto) {
        for (int i = 0; i < userLottos.getLottos().size(); i++) {
            calculateLotto(userLottos, userLottos.getLottos().get(i).getLotto(), lotto);
        }
    }

    public void calculateLotto(UserLottos userLottos, List<Integer> userLotto, Lotto lotto) {
        int correctCount = getCorrectCount(userLotto, lotto);
        if (isCorrectedFive(userLotto, lotto, correctCount)) {
            getPrize(userLottos, correctCount);
            return;
        }
        if (isCorrectedFiveWithBonus(userLotto, lotto, correctCount)) {
            getPrize(userLottos, Prize.BONUS.getCorrecting());
            return;
        }
        if (isCorrectedNonFive(correctCount)) {
            getPrize(userLottos, correctCount);
        }
    }

    public void setCountPrices(Prize prize) {
        countPrices.put(prize, countPrices.getOrDefault(prize, 0) + 1);
    }

    public void getPrize(UserLottos userLottos, int correctCount) {
        setCountPrices(Prize.THREE.getCorrectPrize(correctCount));
        userLottos.setWinningPrice(Prize.THREE.getCorrectPrize(correctCount).getPrice());
    }

    public int getCorrectCount(List<Integer> userLotto, Lotto lotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_NUM_AMMOUNT; i++) {
            if (userLotto.contains(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isCorrectedFive(List<Integer> userLotto, Lotto lotto, int correctCount) {
        return correctCount == FIVE_NUM_CORRECT && !userLotto.contains(lotto.getBonusNum());
    }

    public boolean isCorrectedFiveWithBonus(List<Integer> userLotto, Lotto lotto, int correctCount) {
        return correctCount == FIVE_NUM_CORRECT && userLotto.contains(lotto.getBonusNum());
    }

    public boolean isCorrectedNonFive(int correctCount) {
        return (correctCount == THREE_NUM_CORRECT || correctCount == FOUR_NUM_CORRECT
                || correctCount == SIX_NUM_CORRECT);
    }
}
