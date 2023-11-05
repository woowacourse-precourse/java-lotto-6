package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Prize;

public class LottoManager {

    public static List<Lotto> sortLottos(List<Lotto> lottos) {
        List<Lotto> sortedLottos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> copiedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(copiedNumbers);
            sortedLottos.add(new Lotto(copiedNumbers));
        }

        return sortedLottos;
    }

    public static Integer countMatching(Lotto userLotto, Lotto winningLotto) {
        Integer countMatching = 0;

        for (int i = 0; i < 6; i++) {
            if (userLotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                countMatching++;
            }
        }

        return countMatching;
    }

    public static LottoResult checkWinning(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto userLotto : lottos) {
            Integer countMatching = countMatching(userLotto, winningLotto);

            if (countMatching >= Prize.FIFTH.getMatchingNumber()) {
                Prize prize = Prize.rank(countMatching, userLotto.getNumbers().contains(bonusNumber));
                lottoResult.state.replace(prize, lottoResult.state.get(prize) + 1);
            }

        }

        return lottoResult;
    }


}
