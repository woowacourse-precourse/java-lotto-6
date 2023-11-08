package lotto.adapter;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.port.LottoNumbersProvider;

public class RandomLottoNumbersProvider implements LottoNumbersProvider {
    @Override
    public Lotto provideLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                                             .stream()
                                             .sorted()
                                             .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}