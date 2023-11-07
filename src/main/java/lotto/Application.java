package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = buyLotto.buy();
        List<Integer> correctNumbers = buyLotto.getCorrectNumbers();
        int bonus = buyLotto.getBonus();

        lottoMachine.judge(lottos, correctNumbers, bonus);

    }
}
