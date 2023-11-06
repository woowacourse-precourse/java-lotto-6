package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final int lottoPrice = 1000;

    public List<Lotto> getLotto( int purchaseAmount ){
        if(purchaseAmount % lottoPrice != 0){
            throw new IllegalArgumentException();
        }

        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = purchaseAmount/lottoPrice;
        for(int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }


}
