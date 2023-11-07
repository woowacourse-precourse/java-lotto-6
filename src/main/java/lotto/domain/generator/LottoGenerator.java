package lotto.domain.generator;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constant.Number.*;

public class LottoGenerator {

    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        return new Lotto(generateLottoNumber());
    }

    public List<Integer> generateLottoNumber() {
        return sortLottoNumber(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_LENGTH));
    }

    public List<Integer> sortLottoNumber(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
        return lotto;
    }
}
