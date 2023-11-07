package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public static Lottos create(Integer ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(count -> Lotto.create())
                .toList();

        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Result calcuateResult(Buyer buyer) {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        lottos.forEach(lotto -> {
            Rank rank = buyer.calculateComparingResult(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });

        return new Result(result);
    }
}
