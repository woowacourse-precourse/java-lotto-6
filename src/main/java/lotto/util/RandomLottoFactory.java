package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoFactory {

    private static final int LOTTO_NUMBER_CNT = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            lottos.add(generateOneLotto());
        }

        return lottos;
    }

    private static Lotto generateOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_CNT);
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).sorted().toList();
        return new Lotto(lottoNumbers);
    }
}
