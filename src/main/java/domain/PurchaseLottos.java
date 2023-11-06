package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : domain
 * fileName       : PurchaseLottos
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class PurchaseLottos {

    private final List<Lotto> purchaseLottos;
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
        return new Lotto(new LottoOneSet().generateRandomNumbers());
    }
}
