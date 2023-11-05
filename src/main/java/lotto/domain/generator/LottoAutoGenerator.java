package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.exception.LottoException;

import java.util.*;

import static lotto.constant.LottoConstants.*;

public class LottoAutoGenerator {
    public Lottos generate(int count) throws LottoException {
        Set<Lotto> uniqueLottos = new HashSet<>();
        while (uniqueLottos.size() < count) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Lotto lotto = generateLotto(randomNumbers);
            uniqueLottos.add(lotto);
        }
        return new Lottos(new ArrayList<>(uniqueLottos)); // 명시적 형변환
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

    private static Lotto generateLotto(List<Integer> randomLottoNumbers) throws LottoException {
        return new Lotto(randomLottoNumbers);
    }
}
