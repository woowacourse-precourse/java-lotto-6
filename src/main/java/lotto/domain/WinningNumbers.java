package lotto.domain;

import lotto.constant.WinningNumberConstant;

import java.util.List;
import java.util.Map;

public class WinningNumbers {
    private final Lotto winningLotto;
    private int bonusNumber;
    private GameResult gameResult;

    public WinningNumbers(String lottoNumbers) {
        winningLotto = new Lotto(lottoNumbers);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getLottoNumbers();
    }

    public void setBonusNumber(String lottoWinningBonus) {
        this.bonusNumber = parseInteger(lottoWinningBonus);
    }

    public Map<Integer, Integer> countTotalLottoPrizes() {
        return gameResult.getWinningCountByRank();
    }

    public double totalProfitMargin() {
        return gameResult.getProfitMarginPercentage();
    }

    private int parseInteger(String value) {
        return Integer.parseInt(value);
    }

    public void compareWithUserLotto(List<Lotto> userLottos, int userMoney) {
        gameResult = new GameResult();
        for (Lotto userLotto : userLottos) {
            int sameNumberCount = countMatchingNumbers(userLotto);
            gameResult.incrementWinningCount(sameNumberCount);
            gameResult.addTotalWinningAmount(sameNumberCount);
        }
        gameResult.calculateProfitMargin(userMoney);
    }

    private int countMatchingNumbers(Lotto userLotto) {
        int sameNumberCount = 0;
        for (Integer lottoNumber : winningLotto.getLottoNumbers()) {
            if (userLotto.checkUserAndLottoNumbers(userLotto.getLottoNumbers(), lottoNumber)) {
                sameNumberCount++;
            }
        }
        if (hasSameFiveNumbersAndBonus(userLotto, sameNumberCount)) {
            sameNumberCount *= WinningNumberConstant.MULTIPLIER_FOR_BONUS;
        }
        return sameNumberCount;
    }

    private boolean hasSameFiveNumbersAndBonus(Lotto userLotto, int sameNumberCount) {
        return sameNumberCount == WinningNumberConstant.MATCHING_COUNT_FOR_BONUS && userLotto.checkUserAndLottoNumbers(userLotto.getLottoNumbers(), bonusNumber);
    }
}
