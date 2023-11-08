package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private int lottoCount;
    private List<Lotto> lottos;
    public LottoGenerator(long money) {
        this.lottoCount = (int) money / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }

}
