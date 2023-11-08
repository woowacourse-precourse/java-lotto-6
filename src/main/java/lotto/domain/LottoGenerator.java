package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    public List<Lotto> generateLottoBundle(int price) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            lottoList.add(generate());
        }
        return lottoList;
    }

    private Lotto generate() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE);
        List<Integer> sortedLotto = lotto.stream().sorted().collect(Collectors.toList());
        return new Lotto(sortedLotto);
    }
}
