package lotto.model.domain.lotto.lottogenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constance.GameConst;
import lotto.model.domain.lotto.Lotto;

/**
 * 랜덤한 값을 사용하여 {@link Lotto}를 생성합니다.
 */
public class RandomLottoGenerator extends LottoGenerator<Lotto> {

    private List<Integer> generateList() {
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
