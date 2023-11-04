package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    private Long id = 0L;
    private final ArrayList<Lotto> lotteries = new ArrayList<>();

    public void save(Lotto lotto) {
        lotteries.add(lotto);
    }

    public ArrayList<Lotto> getLotteries() {
        return lotteries;
    }

    //    public Lotto findById(Long id) {
//        return lotteries.get(id);
//    }

//    public ArrayList<Lotto> findAll() {
//        return new ArrayList<>(lotteries.values());
//    }
}
