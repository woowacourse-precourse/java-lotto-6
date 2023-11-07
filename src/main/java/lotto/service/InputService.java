package lotto.service;

import lotto.validation.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class InputService {
    InputView inputView;
    InputValidation inputValidation;
    OutputView outputView;

    private static final int DIVISION_THOUSAND = 1000;

    public InputService(InputView inputView, InputValidation inputValidation, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidation = inputValidation;
        this.outputView = outputView;
    }

    public int readPurchasingAmount() {
        while(true) {
            try {
                String purchasingAmount = inputView.readInput();
                if (inputValidation.validatePurchasingAmount(purchasingAmount)) {
                    return getPurchaseCount(purchasingAmount);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        while(true) {
            try {
                String winningNumbers = inputView.readInput();

                if (inputValidation.validateWinningNumber(winningNumbers)) {
                    return getWinningNumber(winningNumbers);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        while(true) {
            try {
                String bonusNumber = inputView.readInput();

                if (inputValidation.validateBonusNumber(winningNumbers, bonusNumber)) {
                    return Integer.parseInt(bonusNumber);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getPurchaseCount(String purchasingAmount) {
        return Integer.parseInt(purchasingAmount) / DIVISION_THOUSAND;
    }

    private List<Integer> getWinningNumber(String winningNumbers) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] numbers = winningNumbers.split(",");

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            winningNumber.add(num);
        }
        return winningNumber;
    }
}
