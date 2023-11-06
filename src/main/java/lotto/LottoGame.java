package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private static final int FIRST_NUM = 1;
    private static final int LAST_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    private int numOfLotto;
    private List<Lotto> lottos;

    public LottoGame(int numOfPurchase) {
        this.numOfLotto = numOfPurchase;
        this.lottos = new ArrayList<>();
    }

    public Lottos issueLottos() {
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(makeLotto(new RandomNumGenerator(FIRST_NUM, LAST_NUM)));
        }
        return new Lottos(lottos);
    }

    private Lotto makeLotto(RandomNumGenerator generator) {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lotto.add(drawNumber(generator, lotto));
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    private static int drawNumber(RandomNumGenerator generator, List<Integer> lotto) {
        int num;
        do {
            num = generator.generate();
        } while (lotto.contains(num));
        return num;
    }
}
