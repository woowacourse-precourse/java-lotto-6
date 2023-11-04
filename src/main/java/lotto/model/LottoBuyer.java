package lotto.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.win.Rank;

public class LottoBuyer {
    private List<Lotto> lottoTickets;
    private Lotto target;
    private int bonus;

    public LottoBuyer(List<Lotto> lottoTickets, Lotto target, int bonus) {
        this.lottoTickets = lottoTickets;
        this.target = target;
        this.bonus = bonus;
    }

    public Lotto getLotto(int index) {
        return lottoTickets.get(index);
    }

    public int size() {
        return lottoTickets.size();
    }

    public Map<Rank, Integer> checkAllLotto() {
        Map<Rank, Integer> result = initMap();
        lottoTickets.forEach(lotto -> {
            Rank rank = lotto.checkResult(target, bonus);
            if (rank.equals(Rank.FAIL)){
                return;
            }
            Integer savedNum = result.get(rank);
            result.put(rank, ++savedNum);
        });
        return result;
    }

    private Map<Rank,Integer> initMap() {
        Map<Rank, Integer> map = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(winResult -> !winResult.equals(Rank.FAIL))
                .forEach(winResult -> map.put(winResult,0));
        return map;
    }
}
