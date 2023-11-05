package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.output.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoManager lottoManager = LottoManager.getInstance();
        LottoGame lottoGame = new LottoGame();

        System.out.println(OutputView.INPUT_COST.getMessage());
        lottoGame.getRightCost();

        System.out.println("\n" + lottoManager.getNumberOfLottos() + OutputView.NUMBER_OF_LOTTOS.getMessage());
        List<Lotto> allLottos = lottoGame.addLottos();
        // TODO 출력형식, 정력 맞추기
        System.out.println(allLottos);
    }
}
