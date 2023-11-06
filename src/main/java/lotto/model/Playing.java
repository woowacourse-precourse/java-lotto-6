package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Playing {

    public static List<Lotto> lottos = new ArrayList<>();

    public static void updateLottos(int lottoCnt){
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
