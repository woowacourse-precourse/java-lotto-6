package lotto.core;

import lotto.util.LottoConst;
import lotto.util.RandomNumGenerator;
import lotto.util.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private int numOfLotto;
    private Lottos lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Lottos issueLottos() {
        return this.lottos;
    }

    public Lottos makeLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(makeLotto(new RandomNumGenerator(LottoConst.FIRST_NUM, LottoConst.LAST_NUM)));
        }
        return new Lottos(lottos);
    }

    public Lotto makeLotto(RandomNumGenerator generator) {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LottoConst.LOTTO_SIZE; i++) {
            lotto.add(drawNumber(generator, lotto));
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public static int drawNumber(RandomNumGenerator generator, List<Integer> lotto) {
        int num;
        do {
            num = generator.generate();
        } while (lotto.contains(num));
        return num;
    }

    public void setNumOfLotto(int numOfPurchase) {
        this.numOfLotto = numOfPurchase;
    }


    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
