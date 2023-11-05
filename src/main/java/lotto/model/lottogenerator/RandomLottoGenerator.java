package lotto.model.lottogenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constance.GameConst;
import lotto.model.domain.Lotto;

public class RandomLottoGenerator extends LottoGenerator{

    public List<Integer> generateList() {
        return Randoms.pickUniqueNumbersInRange(GameConst.LOTTO_RANGE_START
                , GameConst.LOTTO_RANGE_END
                , GameConst.LOTTO_SIZE);
    }

    @Override
    public Lotto generate() {
        List<Integer> lottoNumbers = generateList();
        return new Lotto(lottoNumbers);
    }
}
