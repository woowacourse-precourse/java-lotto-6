package controller;

import java.util.ArrayList;
import java.util.List;
import view.*;
import model.*;


public class LottoManager {
    private final List<List<Integer>> fullLottoValue = new ArrayList<>();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Transform transform = new Transform();
    Validation validation = new Validation();

    public void lottoStart() {
        int payment;
        int lottoCount;
        List<Integer> winningNumbers;
        int bonusNumber;
        List<Integer> winningStaticsResult;
        double totalReturn;
        outputView.printLottoPriceInputNotify();
        payment = inputView.lottoPriceInput();
        lottoCount = validation.lottoPurchaseNumber(payment);
        outputView.printLottoNumberNotify(lottoCount);

        for(int index = 0; index < lottoCount; index++) {
             transform.fullLottoValue(fullLottoValue, transform.generateRandomList());
             outputView.printRandomNumber(fullLottoValue.get(index));
        }
        outputView.printWinningNumberInputNotify();
        String winningNumberString = inputView.lottoWinningNumberInput();
        winningNumbers = transform.winningNumberToList(winningNumberString);
        outputView.printBonusNumberInputNotify();
        bonusNumber = inputView.bonusNumberInput();
        validation.inputFinalValue(winningNumbers, bonusNumber);
        winningStaticsResult = validation.winningStatics(fullLottoValue);
        outputView.printWinningStatics(winningStaticsResult);

        totalReturn = validation.totalReturnCalculate(winningStaticsResult, payment);
        outputView.printTotalReturn(totalReturn);
    }


}
