package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Constants.LottoRules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickPicks {

    private static final Integer MAX = LottoRules.MAX_LOTTO_BALL_RANGE.getNumber();
    private static final Integer MIN = LottoRules.MIN_LOTTO_BALL_RANGE.getNumber();
    private static final Integer TOTAL_BALL = LottoRules.TOTAL_BALL_NUMBERS.getNumber();

    public final static List<List<Integer>> lottoLog = new ArrayList<>();

    static List<Integer> scatterQuickPicks() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, TOTAL_BALL);
    }

    public static List<Integer> lottoNumOrganize(List<Integer> sixBalls) {
        List<Integer> balls = new ArrayList<>(sixBalls);
        Collections.sort(balls);
        return balls;
    }

    private void lottoLog(List<Integer> quickPicks) {
        lottoLog.add(quickPicks);
    }

    private void buyLottoGame() {
        List<Integer> lottoGame = scatterQuickPicks();
        List<Integer> sorted = lottoNumOrganize(lottoGame);
        new Lotto(sorted);
        lottoLog(new Lotto(sorted).getNumbers());
    }

    public void lottoPaper(long gameCount) {
        for (int i = 0; i < gameCount; i++) {
            buyLottoGame();
            System.out.println(lottoLog.get(i));
        }
    }
}