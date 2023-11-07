package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.utils.Generator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    public void start() {

        Payment payment = getPaymentFromUser();

        Lottos generatedLottos = createLottos(payment.calculateLottoAmount());
        OutputView.printLottos(generatedLottos);

        WinningNumber winningNumber = getWinningNumberFromUser();
        BonusNumber bonusNumber = getBonusNumberFromUser(winningNumber);

        List<LottoRank> rank = generatedLottos.calculateLottoResult(winningNumber, bonusNumber);
        LottoResult result = new LottoResult(rank);

        printGameResult(result, payment);
    }

    private Payment getPaymentFromUser() {
        try {
            return new Payment(InputView.getPaymentFromUserInput());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPaymentFromUser();
        }
    }

    private Lottos createLottos(int amount) {
        List<Lotto> generatedLotto = Generator.generateLottoByAmount(amount);
        return new Lottos(generatedLotto);
    }

    private WinningNumber getWinningNumberFromUser() {
        try {
            return new WinningNumber(InputView.getWinningNumbersFromUserInput());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningNumberFromUser();
        }
    }

    private BonusNumber getBonusNumberFromUser(WinningNumber winningNumber) {
        try{
            int bonNum = InputView.getBonusNumberFromUserInput();
            return new BonusNumber(winningNumber, bonNum);
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            return getBonusNumberFromUser(winningNumber);
        }
    }

    private void printGameResult(LottoResult result, Payment payment) {
        OutputView.printWinningResult(result);

        String returnRate = payment.getReturnRate(result.getLottoRewardSum());
        OutputView.printReturnRate(returnRate);

        Console.close();
    }
}
