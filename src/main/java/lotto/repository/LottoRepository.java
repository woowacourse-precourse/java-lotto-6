package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    private Long id = 0L;

    private final ArrayList<Lotto>  purchasedLotteries = new ArrayList<>();

    public void save(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }

    public ArrayList<Lotto> getLotteries() {
        return purchasedLotteries;
    }



    //    public Lotto findById(Long id) {
//        return lotteries.get(id);
//    }

//    public ArrayList<Lotto> findAll() {
//        return new ArrayList<>(lotteries.values());
//    }
}
