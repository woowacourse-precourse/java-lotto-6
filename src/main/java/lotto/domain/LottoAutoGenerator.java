package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.contant.LottoConstants.*;

public class LottoAutoGenerator {
    public Lottos generate(int count) throws LottoException {
        Set<Lotto> uniqueLottos = new HashSet<>();
        while (uniqueLottos.size() < count) {
            List<Integer> randomNumbers = generateRandomNumbers();
            List<LottoNumber> lottoNumbers = generateCreateNumbers(randomNumbers);
            Lotto lotto = generateLotto(lottoNumbers);
            uniqueLottos.add(lotto);
        }
        return new Lottos(new ArrayList<>(uniqueLottos)); // 명시적 형변환
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

    private static List<LottoNumber> generateCreateNumbers(List<Integer> randomNumbers) throws LottoException {
        return randomNumbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private static Lotto generateLotto(List<LottoNumber> randomLottoNumbers) {
        return new Lotto(randomLottoNumbers);
    }
}
