package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int number, LottoNumberGenerator lottoNumberGenerator) {
        return new Lottos(createLottos(number, lottoNumberGenerator));
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
}
