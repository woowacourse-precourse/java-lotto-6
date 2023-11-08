package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i<count; i++){
            List<Integer> lottoNumbers = new ArrayList<>(generateLottoNumbers());
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
