package lotto.Controller;

import lotto.Domain.Human;
import lotto.RandomGenerator.LottoGenerator;

public class LottoController {
    private Human human;

    public void gameStart(String budgets) {
        // Exception Checking will be here
        // If Exception occur -> return
        human = new Human(Long.parseLong(budgets));
        // return Successful
    }

    public void buyLottos() {

        LottoGenerator lottoGenerator = new LottoGenerator();

        while (human.buyLotto()) {
            human.addLotto(lottoGenerator.getLottoNumber());
        }

        // Return -> is successful
    }

    public int getPurchasedCnt() {
        return human.getLottosLength();
    }
}
