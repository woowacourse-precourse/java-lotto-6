package lotto.util;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class MakeLotto {
    private static Lotto generateLotto() {
        MakeRandomNumber makeRandomNumber = new MakeRandomNumber();
        return new Lotto(makeRandomNumber.getRandomNumber());
    }

    public List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }


}
