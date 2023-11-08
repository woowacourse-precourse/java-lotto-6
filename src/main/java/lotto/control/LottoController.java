package lotto.control;

import lotto.model.Lotto;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private OutputManager outputManager = OutputManager.getInstance();
    private InputManager inputManager = InputManager.getInstance();
    private final int WINNING_NUMBER_SCORE = 10;
    private final int BONUS_NUMBER_SCORE = 5;
    private final int ZERO_SCORE = 0;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<Integer, Integer> statistic;
    private int totalReward;
    private final int FIRST_REWARD = 2_000_000_000;
    private final int SECOND_REWARD = 30_000_000;
    private final int THIRD_REWARD = 1_500_000;
    private final int FOURTH_REWARD = 50_000;
    private final int FIFTH_REWARD = 5_000;

    public void simulate() {

        outputManager.requestMoney();
        int purchaseAmount = inputManager.getPurchaseAmount();

        createLotto(purchaseAmount);
        outputManager.printPurchaseMessage(purchaseAmount);
        for (Lotto lotto : lottos) {
            outputManager.printLotto(lotto.getLottoNumbers());
        }
        outputManager.requestWinningNumbers();
        winningNumbers = inputManager.getWinningNumbers();
        outputManager.requestBonusNumber();
        bonusNumber = inputManager.getBonusNumber();

        createStatistic();
        outputManager.printStatistic(statistic);
        calculateProfit();

        outputManager.printRateOfReturn(totalReward, purchaseAmount);

    }

    public void createLotto(int purchaseAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Lotto.getRandomNumbers()));
        }
    }

    public void drawNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void createStatistic() {
        statistic = new HashMap<>();
        for (Lotto lotto : lottos) {
            //번호 일치 여부에 따라 점수 지급
            int score = compareWithWinningNumbers(lotto.getLottoNumbers()) +
                    compareWithBonusNumbers(lotto.getLottoNumbers());
            statistic.put(score, statistic.getOrDefault(score, 0) + 1);
        }
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

    public void calculateProfit() {
        totalReward = 0;
        totalReward += statistic.getOrDefault(30, 0) * FIFTH_REWARD;
        totalReward += statistic.getOrDefault(40, 0) * FOURTH_REWARD;
        totalReward += statistic.getOrDefault(50, 0) * THIRD_REWARD;
        totalReward += statistic.getOrDefault(55, 0) * SECOND_REWARD;
        totalReward += statistic.getOrDefault(60, 0) * FIRST_REWARD;
    }
}
