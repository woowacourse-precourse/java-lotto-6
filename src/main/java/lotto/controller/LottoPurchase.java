package lotto.controller;

import lotto.exception.AmountException;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {
    private final AmountException amountException;
    private final InputView inputView;

    public LottoPurchase(InputView inputView) {
        amountException = new AmountException();
        this.inputView = inputView;
    }

    private boolean isCorrectAmount(String input) {
        try {
            amountException.checkBlank(input);             //빈칸 입력
            amountException.checkEmptySpace(input);        //공백
            amountException.checkPositiveInteger(input);   //자연수
            amountException.checkOutOfIntegerRange(input); //정수 범위
            amountException.checkLessThanMaxAmount(input); //구매금액의 최댓값
            amountException.checkThousandUnits(input);     //1,000단위 입력
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    public int inputAmount() {
        String input;

        while (true) {
            inputView.showAmountInputForm();
            input = readLine().trim();
            inputView.endInput();

            if (isCorrectAmount(input)) {
                break;
            }
        }

        return Integer.parseInt(input);
    }
}
