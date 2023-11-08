package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoBuyer {
    private final List<Lotto> lottoTickets;

    public LottoBuyer(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Rank, Integer> checkAllLotto(Lotto target, int bonus) {
        Map<Rank, Integer> result = initMap();
        lottoTickets.forEach(lotto -> {
            Rank rank = lotto.match(target, bonus);
            Integer savedNum = result.get(rank);
            result.put(rank, ++savedNum);
        });
        return result;
    }

    //출력형식 순서를 지키기 위함.
    private Map<Rank, Integer> initMap() {
        Map<Rank, Integer> map = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .forEach(winResult -> map.put(winResult, 0));
        return map;
    }
}
