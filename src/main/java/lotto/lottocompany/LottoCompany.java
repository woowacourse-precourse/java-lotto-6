package lotto.lottocompany;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoCompany {

    private final LottoBundle lottoBundle;
    private final RewardHistory rewardHistory;

    public LottoCompany() {
        this.lottoBundle = LottoBundle.create(new ArrayList<>());
        this.rewardHistory = RewardHistory.create(new ArrayList<>());
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }

    public RewardHistory getRewardHistory() {
        return rewardHistory;
    }

    public LottoBundle publishNLotto(int publishCount) {
        List<Lotto> bundle = new ArrayList<>(publishCount);
        for (int count = 0; count < publishCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            sortedNumbers.sort(Comparator.naturalOrder());
            bundle.add(new Lotto(sortedNumbers));
        }
        lottoBundle.addLotto(bundle);
        return lottoBundle;
    }

    public void calculateReward(List<Integer> winningNumbers, int bonusNumber) {
        List<Reward> rewards = lottoBundle.getBundle().stream()
                .map(lotto -> lotto.checkWinning(winningNumbers, bonusNumber))
                .toList();
        rewardHistory.addReward(rewards);
    }
}
