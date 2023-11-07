package lotto.Controller;

import java.util.List;
import lotto.Model.Lotto;

public class AppController {

    private BuyLottoController buyLottoController;
    private GenerateLottosController generateLottosController;
    private InputNumberController inputNumberController;
    private MatchLottoController matchLottoController;
    private ResultController resultController;

    public void playApp() {
        buyLottoController = new BuyLottoController();
        int countLotto = buyLottoController.getCountLotto();

        generateLottosController = new GenerateLottosController(countLotto);
        List<Lotto> lottos = generateLottosController.getLottos();

        inputNumberController = new InputNumberController();
        List<Integer> winningNumbers = inputNumberController.getWinningNumber();
        int bonus = inputNumberController.getBonus();

        matchLottoController = new MatchLottoController(lottos, winningNumbers, bonus);
        List <Integer> winsCount = matchLottoController.getWinsCount();

        resultController = new ResultController(winsCount, countLotto);
    }
}
