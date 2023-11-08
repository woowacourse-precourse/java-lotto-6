package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.enumerate.Rank;
import lotto.util.LottoNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int number, LottoNumberGenerator lottoNumberGenerator) {
        return new Lottos(createLottos(number, lottoNumberGenerator));
    }
    public List<Lotto> getLottos() {
        return this.lottos;
    }
    public int getLottosSize() {
        return this.lottos.size();
    }
    private static List<Lotto> createLottos(int number, LottoNumberGenerator lottoTicketGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            List<Integer> lottoNumbers = lottoTicketGenerator.makeRandom();
            Lotto lotto = new Lotto(lottoNumbers);

            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoResult determine(WinningLotto winningLotto) {
        Map<Rank, Integer> ranks = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = lotto.compare(winningLotto);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }

        return new LottoResult(ranks);
    }

}
