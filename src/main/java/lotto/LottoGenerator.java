package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Validator.LottoValidator;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

    private static List<Integer> getRandomNumbers(int numberCount) {
        return Randoms.pickUniqueNumbersInRange(1, 45, numberCount);
    }

    public static List<Lotto> getLottosByCount(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottos.add(new Lotto((getRandomNumbers(LottoValidator.getLottoSize()))));
        }
        return lottos;
    }
}
