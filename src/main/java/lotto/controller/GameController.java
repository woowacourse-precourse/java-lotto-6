package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.utils.Generator;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    public void start() {

        Payment payment = getPaymentFromUser();

        Lottos generatedLottos = createLottos(payment.calculateLottoAmount());
        OutputView.printGeneratedLottos(generatedLottos);

        WinningNumber winningNumber = getWinningNumberFromUser();
        BonusNumber bonusNumber = getBonusNumberFromUser(winningNumber);

        List<LottoRank> rank = generatedLottos.calculateLottoResult(winningNumber, bonusNumber);
        LottoResult result = new LottoResult(rank);

        printGameResult(result, payment);

        Console.close();
    }

    private Payment getPaymentFromUser() {
        return new Payment(InputView.getPaymentFromUserInput());
    }

    private Lottos createLottos(int amount) {
        List<Lotto> generatedLotto = Generator.generateLottoByAmount(amount);
        return new Lottos(generatedLotto);
    }

    private WinningNumber getWinningNumberFromUser() {
        return new WinningNumber(InputView.getWinningNumbersFromUserInput());
    }

    private BonusNumber getBonusNumberFromUser(WinningNumber winningNumber) {
        int bonNum = InputView.getBonusNumberFromUserInput();
        return new BonusNumber(winningNumber, bonNum);
    }

    private void printGameResult(LottoResult result, Payment payment) {
        OutputView.printWinningResult(result);

        String returnRate = payment.getReturnRate(result.calculateLottoReward());
        OutputView.printReturnRate(returnRate);
    }
}
