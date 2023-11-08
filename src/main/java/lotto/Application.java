package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.buyLottos();

        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.printLottos(lottos);

        InputManager inputManager = new InputManager();
        Lotto winningLotto = inputManager.getWinningLotto();
        int bonusNumber = inputManager.getBonusNumber();

        ResultCalculator resultCalculator = new ResultCalculator();
        WinningResult result = resultCalculator.calculateWinningResult(lottos, winningLotto, bonusNumber);

        resultPrinter.printResult(result, lottos.size());
        resultPrinter.printEarningsRate(result, lottos.size());
    }
}