package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static List<Integer> LottoGenerate(int amountLotto){
        List<Integer> randomlotto = new ArrayList<>();
        for (int i = 0; i < amountLotto; i++){
            Lottos lottos = new Lottos(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            randomlotto = lottos.getRandomLottos();
        }
        return randomlotto;
    }
}
