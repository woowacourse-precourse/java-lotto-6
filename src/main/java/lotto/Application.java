package lotto;

import lotto.domain.Lottos;
import lotto.output.OutputView;

public class Application {
    public static void main(String[] args) {

        System.out.println(OutputView.INPUT_COST.getMessage());

        Lottos lottos = null;
        while (true) {
            lottos = LottoGame.getRightCost(lottos);
            if (lottos!=null) {
                break;
            }
        }

        System.out.println('\n' + lottos.printOutNumberOfLottos());



    }
}
