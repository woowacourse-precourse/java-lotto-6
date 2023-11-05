package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static Lottos of(final int numberOfLottos, final LottoGenerator lottoGenerator){
        final List<Lotto> purchasedLottos = new ArrayList<>(numberOfLottos);

        for(int i=0; i < numberOfLottos ; i++){
            final Lotto newLotto = lottoGenerator.generate();
            purchasedLottos.add(newLotto);
        }

        return new Lottos(purchasedLottos);
    }

    public List<LottoDTO> toLottoDtos(){
        return lottos.stream()
                .map(Lotto::toLottoDTO)
                .toList();
    }


}
