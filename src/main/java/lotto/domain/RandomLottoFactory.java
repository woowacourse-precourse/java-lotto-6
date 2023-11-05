package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoFactory {

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).toList();
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
