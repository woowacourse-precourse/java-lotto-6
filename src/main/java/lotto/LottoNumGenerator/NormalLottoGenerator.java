package lotto.LottoNumGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NormalLottoGenerator implements LottoGenerator{
    @Override
    public List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
