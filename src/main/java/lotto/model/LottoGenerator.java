package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private int lottoCount;
    private List<Lotto> lottos;
    public LottoGenerator(long money) {
        this.lottoCount = (int) money / 1000;
        generateLotto();
    }

    private void generateLotto() {
        lottos = IntStream.range(0, lottoCount).mapToObj(i -> new Lotto(generateRandomNumber())).collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
