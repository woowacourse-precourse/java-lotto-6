package lotto;

import lotto.controller.CalculateController;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.view.PrintResult;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.run();

        List<Lotto> lottos = new ArrayList<>(lottoController.getLottos());

        CalculateController calculateController = new CalculateController(lottos,lottoController.getPrizeNumbers(),
                lottoController.getBonusNumber(), lottoController.getLottoPrices());
        calculateController.run();

        PrintResult printResult = new PrintResult(calculateController.getResults(), calculateController.calculateRate());
        printResult.run();
    }
}
