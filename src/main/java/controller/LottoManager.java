package controller;

import static constants.ConstantNumbersManager.INDEX_RESET;

import java.util.ArrayList;
import java.util.List;
import model.Transform;
import model.Validation;
import view.InputView;
import view.OutputView;

public class LottoManager {
    private final List<List<Integer>> fullLottoValue = new ArrayList<>();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Transform transform = new Transform();
    private final Validation validation = new Validation();

    public void lottoStart() {
        int payment = getPaymentFromUser();
        int lottoCount = validation.lottoPurchaseNumber(payment);
        outputView.printLottoNumberNotify(lottoCount);

        generateAndPrintRandomLottoNumbers(lottoCount);

        List<Integer> winningNumbers = getWinningNumbersFromUser();
        int bonusNumber = getBonusNumberFromUser();
        validation.userInputValue(winningNumbers, bonusNumber);

        List<Integer> winningStaticsResult = validation.winningStatics(fullLottoValue);
        outputView.printWinningStatics(winningStaticsResult);

        double totalReturn = validation.totalReturnCalculate(winningStaticsResult, payment);
        outputView.printTotalReturn(totalReturn);
    }

    private int getPaymentFromUser() {
        outputView.printLottoPriceInputNotify();
        return inputView.lottoPriceInput();
    }

    private void generateAndPrintRandomLottoNumbers(int lottoCount) {
        for (int index = INDEX_RESET; index < lottoCount; index++) {
            List<Integer> randomLotto = transform.generateRandomList();
            fullLottoValue.add(randomLotto);
            outputView.printRandomNumber(randomLotto);
        }
    }

    private List<Integer> getWinningNumbersFromUser() {
        outputView.printWinningNumberInputNotify();
        String winningNumberString = inputView.lottoWinningNumberInput();
        return transform.winningNumberToList(winningNumberString);
    }

    private int getBonusNumberFromUser() {
        outputView.printBonusNumberInputNotify();
        return inputView.bonusNumberInput();
    }
}
