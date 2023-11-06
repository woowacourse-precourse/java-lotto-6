package lotto.controller;

import lotto.exception.LottoNumberException;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {
    private LottoNumberException lottoNumberException;
    private InputView inputView;

    public LottoPurchase() {
        lottoNumberException = new LottoNumberException();
        inputView = new InputView();
    }

    private boolean isCorrectAmount(String input) {
        try {
            lottoNumberException.checkEmptySpace(input);        //공백
            lottoNumberException.checkPositiveInteger(input);   //자연수
            lottoNumberException.checkOutOfIntegerRange(input); //정수 범위
            lottoNumberException.checkLessThanMaxAmount(input); //구매금액의 최댓값
            lottoNumberException.checkThousandUnits(input);     //1,000단위 입력
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

            if (isCorrectAmount(input)) {
                break;
            }
        }

        return Integer.parseInt(input);
    }
}
