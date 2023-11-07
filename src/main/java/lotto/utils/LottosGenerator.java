package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottosGenerator {
    public static List<Lotto> getLottos(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.getRandomNumber()));
        }

        return lottos;
    }
}
