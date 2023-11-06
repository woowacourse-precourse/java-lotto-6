package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.utils.RandomNumberGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public HashMap<Rank,Integer> chargeResult(WinnerLotto winnerLotto) {
        HashMap<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Optional<Rank> optionalRank = winnerLotto.calcRank(lotto);
            optionalRank.ifPresent((rank)-> result.put(rank,result.getOrDefault(rank,0)+1));
        }

        return result;
    }

    public List<Lotto> getList() {
        return Collections.unmodifiableList(lottos);
    }

    public static Lottos from(Integer count) {
        return new Lottos(generateLottos(count));
    }

    private static List<Lotto> generateLottos(Integer count) {
        return Stream.generate(Lottos::generateLottoNumbers)
                .map(Lotto::new)
                .limit(count)
                .toList();
    }

    private static List<LottoNumber> generateLottoNumbers() {
        return RandomNumberGenerator.generateUniqueNumbers().stream().map(LottoNumber::new).toList();
    }
}
