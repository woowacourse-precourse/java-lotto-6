package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static List<Lotto> generateRandomLottos(int purchaseAmount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseAmount; ++i){
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    public static Lotto generateRandomLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}
