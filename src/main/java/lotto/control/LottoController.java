package lotto.control;

import lotto.model.Lotto;
import lotto.view.OutputManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final int WINNING_NUMBER_SCORE = 10;
    private final int BONUS_NUMBER_SCORE = 5;
    private final int ZERO_SCORE = 0;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Lotto> createLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Lotto.getRandomNumbers()));
        }
        return lottos;
    }

    public void sendLotto(OutputManager outputManager, Lotto lotto) {
        outputManager.printLotto(lotto.getLottoNumbers());
    }

    public void drawNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> createStatistic(List<Lotto> lottos) {
        Map<Integer, Integer> statistic = new HashMap<>();
        for (Lotto lotto : lottos) {
            //번호 일치 여부에 따라 점수 지급
            int score = compareWithWinningNumbers(lotto.getLottoNumbers()) +
                    compareWithBonusNumbers(lotto.getLottoNumbers());
            statistic.put(score, statistic.getOrDefault(score, 0) + 1);
        }
        return statistic;
    }

    public int compareWithWinningNumbers(List<Integer> numbers) {
        int score = ZERO_SCORE;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                score += WINNING_NUMBER_SCORE;
            }
        }
        return score;
    }

    public int compareWithBonusNumbers(List<Integer> numbers) {
        if (numbers.contains(bonusNumber))
            return BONUS_NUMBER_SCORE;
        return ZERO_SCORE;
    }

    public void sendStatistic(OutputManager outputManager, Map<Integer, Integer> statistic) {
        outputManager.printStatistic(statistic);
    }
}
