package lotto.adapter;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.port.LottoNumbersProvider;

public class RandomLottoNumbersProvider implements LottoNumbersProvider {
    @Override
    public List<Integer> provideLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}