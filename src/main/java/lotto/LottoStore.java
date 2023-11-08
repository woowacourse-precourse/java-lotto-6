package lotto;

import util.OutputView;

import java.util.*;

public class LottoStore {
    private List<Lotto> lottos;
    private int[] winCount;

    LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
        this.winCount = new int[] {0,0,0,0,0,0};
    }

    public static LottoStore createLottoStore(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = numberOfLotto ; i > 0 ; i--) {
            lottos.add(Lotto.createLotto());
        }
        OutputView.printLotto(lottos);
        return new LottoStore(lottos);
    }

    public void judgeLotto(LottoWithBounusNumber userLotto) {
        Set checkLotto;
        Lotto lotto = userLotto.getLotto();
        Integer bonusNumber = userLotto.getBonusNumber();
        for (Lotto storeLotto : this.lottos) {
            List<Integer> sumOfLotto = new ArrayList<>();
            sumOfLotto.addAll(storeLotto.getNumbers());
            sumOfLotto.addAll(lotto.getNumbers());
            checkLotto = new HashSet<>(sumOfLotto);
            if (checkLotto.size() == 6) {
                this.winCount[1] += 1;
            } else if (checkLotto.size() == 7) {
                checkLotto.add(bonusNumber);
                if (checkLotto.size() == 7) {
                    this.winCount[2] += 1;
                }
                else if (checkLotto.size() == 8) {
                    this.winCount[3] += 1;
                }
            } else if (checkLotto.size() == 8) {
                this.winCount[4] += 1;
            } else if (checkLotto.size() == 9) {
                this.winCount[5] += 1;
            }
        }
    }

    public int[] getWinCount() {
        return winCount;
    }
}
