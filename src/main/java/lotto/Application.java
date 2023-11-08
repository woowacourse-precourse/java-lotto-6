package lotto;

import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.output.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoManager lottoManager = LottoManager.getInstance();
        LottoGame lottoGame = new LottoGame();

        System.out.println(OutputView.INPUT_COST.getMessage());
        lottoGame.getRightCost();

        System.out.println("\n" + lottoManager.getNumberOfLottos() + OutputView.NUMBER_OF_LOTTOS.getMessage());
        Lottos lottos = new Lottos(lottoGame.addLottos());
        System.out.println(lottos);

        System.out.println(OutputView.INPUT_LUCKY_NUMBER.getMessage());
        lottoGame.getRightLuckyNumbers();
    }
}
