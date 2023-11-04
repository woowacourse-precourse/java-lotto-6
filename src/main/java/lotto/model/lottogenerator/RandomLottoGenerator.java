package lotto.model.lottogenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.domain.Lotto;

public class RandomLottoGenerator extends LottoGenerator implements ListGenerator<Integer> {

    @Override
    public List<Integer> generateList() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_SIZE);
    }

    @Override
    public Lotto generate() {
        List<Integer> lottoNumbers = generateList();
        lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }
}
