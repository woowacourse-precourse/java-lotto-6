package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

    private List<Lotto> lottoList;

    public LottoList(PurchaseAmount amount) {
        lottoList = generateLottoList(amount.getTimes());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private List<Lotto> generateLottoList(int times) {
        return IntStream.range(0, times)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
