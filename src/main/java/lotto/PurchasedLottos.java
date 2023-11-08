package lotto;

import static lotto.LottoGenerator.makeRandomNumbersInLotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PurchasedLottos {

    private List<Lotto> lottos = new ArrayList<>();
    private Map<LottoReward, Integer> rewardmap;

    private final Purchase purchase;

    public PurchasedLottos(Purchase purchase) {
        this.purchase = purchase;
        rewardmap = new EnumMap<>(LottoReward.class);
        for (LottoReward reward : LottoReward.values()) {
            rewardmap.put(reward, 0); // Initialize each reward count to zero
        }
        for (int i = 0; i < purchase.getTicketCount(); i++) {
            Lotto lotto = new Lotto(makeRandomNumbersInLotto());
            lottos.add(lotto);
        }
    }

    public String LottosToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void calculateRewardsInPurchasedLotto(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoReward reward = lotto.getRewardWithMatchedNumbers(winningLotto);
            rewardmap.put(reward, rewardmap.getOrDefault(reward, 0) + 1);
        }
    }

    public double calculateAverageWinnings(WinningLotto winningLotto) {
        long totalWinnings = 0;
        for (Map.Entry<LottoReward, Integer> entry : rewardmap.entrySet()) {
            LottoReward reward = entry.getKey();
            int count = entry.getValue();
            totalWinnings += reward.getWinningReward() * count;
        }
        double averageWinnings = (double) totalWinnings / purchase.getPrice() * 100.0;
        return Math.round(averageWinnings * 10.0) / 10.0;
    }
    public String generateRewardString() {
        StringBuilder rewardStringBuilder = new StringBuilder();

        for (LottoReward reward : LottoReward.values()) {
            if (reward != LottoReward.NOTHING) {
                rewardStringBuilder.append(reward.getMessage());
                rewardStringBuilder.append(rewardmap.getOrDefault(reward, 0));
                rewardStringBuilder.append("개\n");
            }
        }
        return rewardStringBuilder.toString();
    }

}
