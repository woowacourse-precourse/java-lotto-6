package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        Map<Rank, Integer> result = initializeResult();

        lottos.forEach(lotto -> {
            Rank rank = buyer.calculateComparingResult(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });

        return new Result(result);
    }

    private Map<Rank, Integer> initializeResult() {
        Map<Rank, Integer> result = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        return result;
    }

    public String printAllRandomLottos() {
        StringBuilder lottoBuilder = new StringBuilder();

        lottos.forEach(lotto -> lottoBuilder.append(lotto.getLottoNumbers())
                .append("\n"));

        return lottoBuilder.toString();
    }
}
