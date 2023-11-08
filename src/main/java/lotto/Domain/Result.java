package lotto.Domain;

import lotto.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Integer, Integer> result = new HashMap<>();
    private final Map<Integer, Integer> price = Map.of(
            0, 0, 1, 0, 2, 0, 3, 5000,
            4, 50000, 5, 1500000, 6, 2000000000,
            7, 30000000
    );
    private final Long reward;
    private final Utils utils = Utils.INSTANCE;

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public Long getReward() {
        return reward;
    }

    public Result(User user, Lotto winningLotto) {
        match(user, winningLotto);
        this.reward = calculateReward();
    }

    private void match(User user, Lotto winningLotto) {
        List<Lotto> lottos = user.getLottos();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for(Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Integer matchCount = utils.countCommonElements(lottoNumbers, winningNumbers);
            if(matchCount == 5 && lottoNumbers.contains(winningLotto.getBonusNumber())) {
                result.put(7, result.getOrDefault(7, 0) + 1);
                continue;
            }
            result.put(matchCount, result.getOrDefault(matchCount, 0) + 1);
        }
    }

    private Long calculateReward() {
        Long reward = 0L;
        for(Integer key : result.keySet()) {
            reward += (long) result.get(key) * price.get(key);
        }
        return reward;
    }

}
