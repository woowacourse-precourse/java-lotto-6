package lotto.model;

import java.util.List;

public class LottoManager {
    private Lottos lottos;

    private LottoManager(Lottos lottos){
        this.lottos = lottos;

    }
    public static LottoManager of(final int numberOfLottos, final LottoGenerator lottoGenerator){
        return new LottoManager(Lottos.of(numberOfLottos, lottoGenerator));
    }

    public List<List<Integer>> getPurchaseLottos(){
         return lottos.toLottoDtos()
                .stream()
                .map(LottoDTO::numbers)
                .toList();
    }

}
