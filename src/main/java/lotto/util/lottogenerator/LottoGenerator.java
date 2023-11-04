package lotto.util.lottogenerator;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public abstract class LottoGenerator implements ListGenerator<Integer> {
    static final int LOTTO_RANGE_START = 1;
    static final int LOTTO_RANGE_END = 45;
    static final int LOTTO_SIZE = 6;
    static final int LOTTO_PRICE = 1000;

    public Lotto generate() {
        List<Integer> lottoNumbers = generateList();
        lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }

    public Lottos purchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoNum = money / LOTTO_PRICE;
        while (lottos.size() < lottoNum) {
            Lotto generatedLotto = generate();
            lottos.add(generatedLotto);
        }

        return new Lottos(lottos);
    }
}
