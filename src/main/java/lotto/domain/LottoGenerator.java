package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateRandomLottos(int purchaseAmount){
        List<Lotto> lottos = new ArrayList<>();
        System.out.println(purchaseAmount);
        for(int i = 0; i < purchaseAmount; ++i){
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    public static Lotto generateRandomLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
