package lotto.domain;

import static lotto.constants.Value.COUNT_ONE;
import static lotto.constants.Value.INITIAL_ZERO;
import static lotto.constants.Value.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.Prize;

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
        Integer countMatching = INITIAL_ZERO.get();

        for (int index = INITIAL_ZERO.get(); index < LOTTO_SIZE.get(); index++) {
            if (userLotto.getNumbers().contains(winningLotto.getNumbers().get(index))) {
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
                lottoResult.state.replace(prize, lottoResult.state.get(prize) + COUNT_ONE.get());
            }
        }

        return lottoResult;
    }
}
