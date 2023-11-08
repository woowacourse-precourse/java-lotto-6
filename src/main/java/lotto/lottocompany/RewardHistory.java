package lotto.lottocompany;

import static lotto.lottocompany.Reward.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RewardHistory {

    private final List<Reward> history;

    private RewardHistory(List<Reward> history) {
        this.history = history;
    }

    public List<Reward> getHistory() {
        return List.copyOf(history);
    }

    public static RewardHistory create(List<Reward> rewards) {
        return new RewardHistory(rewards);
    }

    public void addReward(List<Reward> rewards) {
        history.addAll(rewards);
    }

    public String announceRewardStatistics() {
        StringBuilder stringBuilder = new StringBuilder("""
                당첨 통계
                ---
                """);
        List<String> statistics = getEachStatistic();
        for (String statistic : statistics) {
            stringBuilder.append(statistic).append("\n");
        }
        return stringBuilder.toString();
    }

    private List<String> getEachStatistic() {
        return Arrays.stream(values())
                .filter(reward -> reward != NONE)
                .map(reward ->
                        reward.getPrizeInformation() + " " + reward.getPrizeMoneyMessage() + " - "
                                + reward.calculateCount(history) + "개")
                .sorted(Comparator.naturalOrder())
                .toList();
    }
}
