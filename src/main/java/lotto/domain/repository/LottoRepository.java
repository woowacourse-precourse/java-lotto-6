package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private static List<Lotto> lottos = new LinkedList<>();

    public static List<Lotto> lottoTickets() {
        return lottos;
    }

    public static void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
