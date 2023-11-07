package lotto.adapter;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.port.LottoNumbersProvider;

public class RandomLottoNumbersProvider implements LottoNumbersProvider {
    @Override
    public List<Integer> provideLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lottoNumbers.stream()
                       .sorted()
                       .collect(Collectors.toList());
    }
}