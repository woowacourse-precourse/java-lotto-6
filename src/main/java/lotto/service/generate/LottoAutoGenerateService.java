package lotto.service.generate;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoConstants.*;

public class LottoAutoGenerateService {
    private static final LottoAutoGenerateService instance = new LottoAutoGenerateService();

    private LottoAutoGenerateService() {}

    public static LottoAutoGenerateService getInstance() {
        return instance;
    }

    public Lottos generate(int count) {
        // Lotto 는 List<LottoNumber> 가지고 있고, LottoNumber 는 Integer 를 가지고 있다.
        // 따라서 Set<Lotto> 는  LottoNumber 6개 모두가 중복되지 않는 로또들을 의미한다.
        Set<Lotto> uniqueLottos = new HashSet<>();
        while (uniqueLottos.size() < count) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Lotto lotto = generateLotto(randomNumbers);
            uniqueLottos.add(lotto);
        }
        return new Lottos(new ArrayList<>(uniqueLottos)); // 명시적 형변환
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

    private static Lotto generateLotto(List<Integer> randomLottoNumbers) throws LottoException {
        return new Lotto(randomLottoNumbers);
    }
}
