package lotto;

import lotto.domain.Lottos;
import lotto.output.OutputView;

public class Application {

    public static void main(String[] args) {

        Lottos lottos = null;

        while (true) {
            System.out.println(OutputView.INPUT_COST.getMessage());
            lottos = LottoGame.getRightCost(lottos);
            if (lottos.existLottos()) {
                break;
            }
        }

        System.out.println('\n' + lottos.printOutNumberOfLottos());

    }
}
