package lotto;

import controller.LottoController;
import controller.UserController;
import java.util.HashMap;
import java.util.List;
import model.Lotto;
import view.InputView;
import view.OutputView;

public class Application {
    static UserController userController = new UserController();
    static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = userController.inputPriceHowManyLottos();

        int lottoAmount = lottoController.calculatelottoMount(purchasePrice);
        List<Lotto> generatedLottos = lottoController.generateLottos(lottoAmount);
        OutputView.showGeneratedLotto(lottoAmount, generatedLottos);

        List<Integer> whatIsUserLottoNumbers = userController.generateUserLottoNumber();
        int bonusNumber = userController.inputBonusNumber();

        HashMap<String, Integer> winningResults = lottoController.calculateHowManyCorrectNumber(
                whatIsUserLottoNumbers, bonusNumber);

        double winningRate = lottoController.calculateWinningRate(lottoAmount, winningResults);
        String formattedRate = String.format("%.1f", winningRate);

        OutputView.showFinalResult(winningResults, formattedRate);
    }
}
