package controller;

import domain.Lotto;
import java.util.List;
import model.CheckLotto;
import model.RandomLotto;

public class LottoController {

    private final int LOTTO_PRICE = 1000;

    private static final RandomLotto randomLotto = new RandomLotto();
    private static final CheckLotto checkLotto = new CheckLotto();
    private static final OutputController outputController = new OutputController();

    public List<Lotto> createRandomLotto(int money) {
        List<Lotto> allLotto = randomLotto.createAllLotto(money / LOTTO_PRICE);
        outputController.outputRandomLotto(money, allLotto);
        return allLotto;
    }

    public int[] checkWinningLotto(Lotto winningBall, int bonusBall, List<Lotto> randomLotto) {
        return checkLotto.checkLotto(winningBall.getNumbers(), bonusBall, randomLotto);
    }

}
