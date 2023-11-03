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
        Map<Prize, Integer> rewardMap = new HashMap<>();
        for (Lotto lotto : user.getLotto()) {
            int count = countLottoByWinningNumbers(lotto, originalWinningNumbers);
            boolean isExistBonusNumber = false;
            if (count == 5) {
                isExistBonusNumber = lotto.getSortedNumbers().contains(winningNumbers.getBonusNumber());
            }
            Prize prize = getPrize(count, isExistBonusNumber);
            if (prize != null) {
                rewardMap.put(prize, rewardMap.getOrDefault(prize, 0) + 1);
            }
        }
        return rewardMap;
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
