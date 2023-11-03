package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.domain.WinningNumbers;

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

    public Map<Prize, Integer> getLotteryResult(User user, WinningNumbers winningNumbers) {
        Set<Integer> originalWinningNumbers = winningNumbers.getOriginalWinningNumbers();
        Map<Prize, Integer> rewardCount = initializeRewardCount();
        for (Lotto lotto : user.getLotto()) {
            int count = countLottoByWinningNumbers(lotto, originalWinningNumbers);
            boolean isExistBonusNumber = false;
            if (count == 5) {
                isExistBonusNumber = lotto.getSortedNumbers().contains(winningNumbers.getBonusNumber());
            }
            Prize prize = getPrize(count, isExistBonusNumber);
            if (prize != null) {
                rewardCount.put(prize, rewardCount.get(prize) + 1);
            }
        }
        return rewardCount;
    }
    public Map<Prize,Integer> initializeRewardCount(){
        Map<Prize, Integer> rewardCount = new HashMap<>();
        rewardCount.put(Prize.FIRST_REWARD, 0);
        rewardCount.put(Prize.SECOND_REWARD, 0);
        rewardCount.put(Prize.THIRD_REWARD, 0);
        rewardCount.put(Prize.FOURTH_REWARD, 0);
        rewardCount.put(Prize.FIFTH_REWARD, 0);
        return rewardCount;
    }

    public int countLottoByWinningNumbers(Lotto lotto, Set<Integer> winningNumbers) {
        List<Integer> userPickNumbers = lotto.getSortedNumbers();
        int count = 0;
        for (Integer userPickNumber : userPickNumbers) {
            if (checkNumber(winningNumbers, userPickNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkNumber(Set<Integer> winningNumbers, int targetNumber) {
        return winningNumbers.contains(targetNumber);
    }

    public Prize getPrize(int count, boolean isExistBonusNumber) {
        if (count == 6) {
            return Prize.FIRST_REWARD;
        }
        if (count == 5) {
            if (isExistBonusNumber) {
                return Prize.SECOND_REWARD;
            }
            return Prize.THIRD_REWARD;
        }
        if (count == 4) {
            return Prize.FOURTH_REWARD;
        }
        if (count == 3) {
            return Prize.FIFTH_REWARD;
        }
        return null;
    }
}
