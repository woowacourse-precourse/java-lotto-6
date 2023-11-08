package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.WinningDetails;

public class Calculate {
    private List<Lotto> lottos;
    private List<Integer> answer;
    private int bonus;
    private final Map<WinningDetails, Integer> rankResult;

    public Calculate(List<Lotto> lottos, List<Integer> answer, int bonus) {
        rankResult = new EnumMap<WinningDetails, Integer>(WinningDetails.class);
        this.lottos = lottos;
        this.answer = answer;
        this.bonus = bonus;
    }

    private void initMap() {
        Arrays.stream(WinningDetails.values())
                .forEach(rank -> rankResult.put(rank, 0));
    }

    private int count(List<Integer> lotto) {
        int count = 0;
        for (Integer integer : answer) {
            if (lotto.contains(integer)) {
                count += 1;
            }
        }
        return count;
    }

    public void countAll() {
        initMap();
        for (int i = 0; i < lottos.size(); i++) {
            int cnt = count(lottos.get(i).getLotto());
            WinningDetails rank = WinningDetails.getRank(cnt, containBonus(lottos.get(i).getLotto()));
            updateRank(rank);
        }
    }

    private void updateRank(WinningDetails rank) {
        int number = rankResult.get(rank);
        rankResult.put(rank, number + 1);
    }

    public boolean containBonus(List<Integer> lotto) {
        return lotto.contains(bonus);
    }

    public Map<WinningDetails, Integer> getRank() {
        return rankResult;
    }
}
