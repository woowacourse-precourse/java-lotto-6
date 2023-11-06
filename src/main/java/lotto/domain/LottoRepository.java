package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private static final LottoRepository instance = new LottoRepository();
    private static final List<Lotto> lottoRepository = new ArrayList<>();

    private LottoRepository() {

    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public void saveAll(List<Lotto> lottos) {
        lottoRepository.addAll(lottos);
    }

    public void save(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public List<Lotto> showAllLottos() {
        return Collections.unmodifiableList(lottoRepository);
    }


}
