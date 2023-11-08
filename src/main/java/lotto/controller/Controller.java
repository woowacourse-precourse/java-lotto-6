package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.view.OutputView.*;

public class Controller {

    private static LottoNumbers lottoNumbers;

    private static WinningNumber winningNumber;

    private static WinningResult winningResult;

    public void run() {
        inputPurchaseAmount();
        drawLottos();
        setWinningNumbers();
        showResults();
    }

    private void inputPurchaseAmount() {
        try {
            int amount = InputView.requestPurchaseAmount();
            lottoNumbers = LottoNumbers.validate(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }
    }

    private void drawLottos() {
        lottoNumbers.drawnLottoNumbers();
        showDrawnLottos(lottoNumbers.getDrawnLottoNumbers());
    }

    private void setWinningNumbers() {
        Lotto winningNumbers = inputWinningNumbers();
        inputBonusNumber(winningNumbers);
    }

    private void inputBonusNumber(Lotto winningNumbers) {
        try {
            int bonusNumber = InputView.requestBonusNumber();
            winningNumber = WinningNumber.validate(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber(winningNumbers);
        }
    }

    private Lotto inputWinningNumbers() {
        try {
            String[] numbers = InputView.requestWinningNumbers();
            List<Integer> winningNumbers = convertType(numbers);
            return Lotto.validate(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public static List<Integer> convertType(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void showResults() {
        winningResult = new WinningResult(lottoNumbers);
        showWinningResult(winningResult.getWinningResult(lottoNumbers.getDrawnLottoNumbers(), winningNumber));
        showTotalReturn(winningResult.getReturn());
    }
}
