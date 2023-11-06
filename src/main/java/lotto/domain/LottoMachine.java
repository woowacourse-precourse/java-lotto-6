package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> createLottosBy(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Lotto(createRandomLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_SIZE);
    }
}
