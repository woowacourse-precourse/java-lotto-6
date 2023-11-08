package lotto.repository;

import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {

    private static final LottoRepository instance = new LottoRepository();

    private LottoRepository() {

    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public Lotto createLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
