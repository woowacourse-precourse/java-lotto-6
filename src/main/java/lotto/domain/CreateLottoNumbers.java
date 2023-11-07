package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoConfig;

public class CreateLottoNumbers {

    private final LottoConfig lottoConfig = new LottoConfig();

    public List<Lotto> createLottoMain(int lottoAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int amount = 0; amount < lottoAmount; amount++) {
            List<Integer> numbers = createLottoMSub();
            System.out.println(numbers);
            lottoNumbers.add(new Lotto(numbers));
        }
        return lottoNumbers;
    }

    private List<Integer> createLottoMSub() {
        return Randoms.pickUniqueNumbersInRange(
                        lottoConfig.LOTTO_MIN_NUM,
                        lottoConfig.LOTTO_MAX_NUM,
                        lottoConfig.LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
