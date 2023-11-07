package domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {

    private final List<Lotto> purchaseLottos;

    public List<Lotto> getPurchaseLottos(){
        return purchaseLottos;
    }
    public PurchaseLottos(int numberOfLottosPurchased){
        this.purchaseLottos = generateLottoNumbersPurchase(numberOfLottosPurchased);
    }

    private List<Lotto> generateLottoNumbersPurchase(int numberOfLottosPurchased){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<numberOfLottosPurchased; i++){
            lottos.add(validatedLotto());
        }
        return lottos;
    }

    private Lotto validatedLotto(){
        return new Lotto(new LottoOneSet().getLottoOneSet());
    }
}
