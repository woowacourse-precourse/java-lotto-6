package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private int lottoCount;
    private List<Lotto> lottos;
    public LottoGenerator(long money) {
        this.lottoCount = (int) money / LottoConstants.LOTTO_PRICE;
        generateLotto();
    }

    private void generateLotto() {
        lottos = IntStream.range(0, lottoCount).mapToObj(i -> new Lotto(generateRandomNumber())).collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER, LottoConstants.TOTAL_LOTTO_NUMBER_COUNT);
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                .map(lotto -> new Lotto(lotto.getNumbers()))
                .collect(Collectors.toUnmodifiableList());
    }
}
