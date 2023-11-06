package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.global.Utils;

public class LottoService {
    public List<Lotto> publish(int quantity) {
        List<Lotto> publishedLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            publishedLotto.add(lotto);
        }
        return publishedLotto;
    }

    public WinningNumbers getWinningNumbers(Set<Integer> originalWinningNumbers, int bonusNumber) {
        return new WinningNumbers(originalWinningNumbers, bonusNumber);
    }

    public Map<Prize, Integer> getRewardCount(List<Lotto> purchasedLotto, WinningNumbers winningNumbers) {
        Set<Integer> originalWinningNumbers = winningNumbers.getOriginalWinningNumbers();
        Map<Prize, Integer> rewardCount = initializeRewardCount();

        for (Lotto lotto : purchasedLotto) {
            int count = countLottoByWinningNumbers(lotto, originalWinningNumbers);
            boolean isExistBonusNumber = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

            Prize prize = getPrize(count, isExistBonusNumber);
            if (prize != null) {
                rewardCount.put(prize, rewardCount.get(prize) + 1);
            }
        }
        return rewardCount;
    }

    public double getRewardRatio(int purchaseAmount, Map<Prize, Integer> lotteryResult) {
        double totalReward = 0;
        for (Prize prize : lotteryResult.keySet()) {
            totalReward += (lotteryResult.get(prize) * prize.getReward());
        }
        double rewardRatio = ((totalReward * 100) / (double) purchaseAmount);
        return Utils.roundNumberBySecondDecimalPlace(rewardRatio);
    }

    Map<Prize, Integer> initializeRewardCount() {
        Map<Prize, Integer> rewardCount = new LinkedHashMap<>();
        rewardCount.put(Prize.FIFTH_REWARD, 0);
        rewardCount.put(Prize.FOURTH_REWARD, 0);
        rewardCount.put(Prize.THIRD_REWARD, 0);
        rewardCount.put(Prize.SECOND_REWARD, 0);
        rewardCount.put(Prize.FIRST_REWARD, 0);
        return rewardCount;
    }

    int countLottoByWinningNumbers(Lotto lotto, Set<Integer> winningNumbers) {
        List<Integer> userPickNumbers = lotto.getNumbers();
        int count = 0;
        for (Integer userPickNumber : userPickNumbers) {
            if (checkNumber(winningNumbers, userPickNumber)) {
                count++;
            }
        }
        return count;
    }

    boolean checkNumber(Set<Integer> winningNumbers, int targetNumber) {
        return winningNumbers.contains(targetNumber);
    }

    Prize getPrize(int count, boolean isExistBonusNumber) {
        if (count == 6) {
            return Prize.FIRST_REWARD;
        }
        if (count == 5) {
            return compareSecondAndThird(isExistBonusNumber);
        }
        if (count == 4) {
            return Prize.FOURTH_REWARD;
        }
        if (count == 3) {
            return Prize.FIFTH_REWARD;
        }
        return null;
    }

    Prize compareSecondAndThird(boolean isExistBonusNumber) {
        if (isExistBonusNumber) {
            return Prize.SECOND_REWARD;
        }
        return Prize.THIRD_REWARD;
    }
}
