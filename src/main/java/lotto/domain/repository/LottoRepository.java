package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private static List<Lotto> lotties = new LinkedList<>();

    public static List<Lotto> lotties() {
        return lotties;
    }

    public static void add(Lotto lotto) {
        lotties.add(lotto);
    }

    public static void clear() {
        lotties.clear();
    }
}
