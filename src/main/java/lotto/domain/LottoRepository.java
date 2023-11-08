package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottoRepository;
    private final EnumMap<LottoPrize, Integer> lottoResult = new EnumMap<>(LottoPrize.class);
    public LottoRepository(){
        lottoRepository = new ArrayList<>();
        for (LottoPrize prize : LottoPrize.values()) {
            lottoResult.put(prize, 0);
        }
    }

    public List<Lotto> getLottoRepository() {
        return lottoRepository;
    }
    public void addOne(Lotto lotto){
        lottoRepository.add(lotto);
    }

    public void addResult(LottoPrize lottoPrize){
        lottoResult.put(lottoPrize,lottoResult.get(lottoPrize)+1);
    }

    public EnumMap<LottoPrize, Integer> getLottoResult() {
        return lottoResult;
    }

}
