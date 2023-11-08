package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoStatistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int minNum = 1;
    private static final int maxNum = 45;
    private static final int pickNum = 6;

    public static List<Lotto> getAllLottos(Long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i<count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minNum, maxNum, pickNum);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static void calculateLottoResult(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.getLottos()) {
            calculateLotto(lotto, lottoGame);
        }
    }

    private static void calculateLotto(Lotto lotto, LottoGame lottoGame) {
        int matchNumber = 0;
        for (int number : lotto.getNumbers()) {
            if (lottoGame.getWinningNumber().getNumbers().contains(number)) {
                matchNumber++;
            }
        }
        if (matchNumber == 5 && lotto.getNumbers().contains(lottoGame.getBonusNumber())) {
            lottoGame.setStatisticMap(LottoStatistic.SECOND);
        }
        if (matchNumber >= 3 && !lotto.getNumbers().contains(lottoGame.getBonusNumber())) {
            setStatistic(matchNumber, lottoGame);
        }
    }

    private static void setStatistic(int matchNumber, LottoGame lottoGame) {
        for (LottoStatistic i : LottoStatistic.values()) {
            if (matchNumber == i.getMatchNumber()) {
                lottoGame.setStatisticMap(i);
            }
        }
    }
}
