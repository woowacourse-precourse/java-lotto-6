package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lotto.domain.Rank;
import lotto.domain.money.Money;
import lotto.utils.RandomNumberGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> chargeResult(WinnerLotto winnerLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Optional<Rank> optionalRank = winnerLotto.calcRank(lotto);
            optionalRank.ifPresent(ranks::add);
        }

        return ranks;
    }

    public List<Lotto> getList() {
        return Collections.unmodifiableList(lottos);
    }

    public Money toMoney() {
        return Money.from(lottos.size() * Money.MINIMUM_AMOUNT);
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
