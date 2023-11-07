package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.Constants;

public class LottoBuyer {
    private final List<Lotto> lottoTickets;

    public LottoBuyer(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Rank, Integer> checkAllLotto(Lotto target, int bonus) {
        Map<Rank, Integer> result = initMap();

        lottoTickets.forEach(lotto -> {
            Rank rank = lotto.match(target, bonus);

            // 꽝은 매핑하지 않는다.
            if (rank.equals(Rank.FAIL)) {
                return;
            }

            Integer savedNum = result.get(rank);
            result.put(rank, ++savedNum);
        });
        return result;
    }

    private Map<Rank, Integer> initMap() {
        Map<Rank, Integer> map = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(winResult -> !winResult.equals(Rank.FAIL))      // 꽝은 매핑하지 않는다.
                .forEach(winResult -> map.put(winResult, 0));
        return map;
    }

    public int payment() {
        return lottoTickets.size() * Constants.LOTTO_PRICE;
    }
}
