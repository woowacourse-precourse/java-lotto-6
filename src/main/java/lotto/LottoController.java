package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constans.GameMessage;
import lotto.constans.WinningGrade;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.User;
import lotto.io.InputView;
import lotto.io.OutputView;

public class LottoController {

    private final User user;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.user = new User();
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        int wantBuyAmount = inputWantBuyAmount();
        List<Lotto> lottos = makeLottos(lottoMachine.wantBuyAmountToQuantity(wantBuyAmount));
        printLottoNumbers(lottos);
        List<Integer> winningNumber = winningNumberInput();
        int bonusNumber = bonusNumberInput(winningNumber);
        String result = makeResult(lottos, winningNumber, bonusNumber, wantBuyAmount);
        printResult(result);
    }

    public int inputWantBuyAmount() {
        int result = 0;
        try {
            OutputView.printMessage(GameMessage.REQUEST_WANT_BUY_AMOUNT.getMessage());
            result = user.inputWantBuyAmount(InputView.userInput());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            result = inputWantBuyAmount();
        }

        return result;

    }

    public List<Lotto> makeLottos(int wantBuyQuantity) {
        System.out.println();
        OutputView.printMessage(wantBuyQuantity + GameMessage.PURCHASE_CONFIRMATION.getMessage());
        return lottoMachine.makeLottos(wantBuyQuantity);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            OutputView.printMessage(lotto.lottoNumbersToString());
        }
    }

    public List<Integer> winningNumberInput() {
        List<Integer> winningNumber = new ArrayList<>();
        System.out.println();
        try {
            OutputView.printMessage(GameMessage.REQUEST_WINNING_NUMBER.getMessage());
            winningNumber = user.inputWinningNumber(InputView.userInput());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            winningNumber = winningNumberInput();
        }

        return winningNumber;
    }

    public int bonusNumberInput(List<Integer> winningNumber) {
        System.out.println();

        int bonusNumber = 0;
        try {
            OutputView.printMessage(GameMessage.REQUEST_BONUS_NUMBER.getMessage());
            bonusNumber = user.inputBonusNumber(InputView.userInput(), winningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            bonusNumber = bonusNumberInput(winningNumber);
        }

        return bonusNumber;

    }

    public String makeResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber, int wantBuyAmount) {
        Map<WinningGrade, Integer> map = lottoMachine.makeResultMap(lottos, winningNumber, bonusNumber);
        return lottoMachine.makeResult(map, wantBuyAmount);
    }

    public void printResult(String result) {
        System.out.println();
        OutputView.printMessage(GameMessage.WINNING_STATISTICS.getMessage());
        OutputView.printMessage(result);
    }
}
