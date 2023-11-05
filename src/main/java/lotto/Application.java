package lotto;

import lotto.domain.LottoManager;
import lotto.output.OutputView;

public class Application {
    public static void main(String[] args) {

        System.out.println(OutputView.INPUT_COST.getMessage());

        LottoManager lottoManager = new LottoManager();
        while (true) {
            LottoGame.getRightCost(lottoManager);
            if (lottoManager.checkNumberOfLottos()) {
                break;
            }
        }

        System.out.println('\n' + lottoManager.printOutNumberOfLottos());

    }
}
