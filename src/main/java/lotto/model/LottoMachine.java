package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomUtil;

public class LottoMachine {

    public static List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> randomNumber = RandomUtil.createLottoNumber();
            randomNumber.sort(Integer::compareTo);
            lottos.add(new Lotto(randomNumber));
        }
        return lottos;
    }
}
