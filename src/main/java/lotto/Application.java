package lotto;

import java.util.List;
import lotto.domain.controller.MainController;
import lotto.domain.model.Lotto;
import lotto.domain.view.OutputType;
import lotto.domain.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        MainController mainController = new MainController();
        int lottoCount = mainController.calculateLottoCount();
        System.out.println(lottoCount + OutputType.PURCHASE_COMPLETE_MESSAGE.getValue());
        List<Lotto> lottos = mainController.generateLottos(lottoCount);
        outputView.printLottoNumbers(lottos);
        // List<int> LottoWinningNumber = inputWinningNumber();
        // checkWinningDetails(LottoWinningNumber, LottoNumbers);
    }
}
