package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.model.constant.LottoConfig.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Integer lottoCount) {
        IntStream.range(ZERO, lottoCount)
                .forEach(count -> lottos.add(new Lotto(lottoGenerator())));
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }


    private static List<Integer> lottoGenerator() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER,LOTTO_SIZE);
    }
}
