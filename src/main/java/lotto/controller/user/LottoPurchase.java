package lotto.controller.user;

import lotto.exception.AmountException;
import lotto.model.LottoReceipt;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;
    private LottoReceipt lottoReceipt;
    private final InputView inputView;

    public LottoPurchase(InputView inputView) {
        this.inputView = inputView;
    }

    private boolean isCorrectAmount(String input) {
        AmountException amountException = new AmountException();

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

    private int inputAmount() {
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

    public void purchase() {
        int amount = inputAmount();
        int count = amount / LOTTO_PRICE;

        lottoReceipt = new LottoReceipt(amount, count);
    }

    public int getCount() {
        return lottoReceipt.getPurchaseCount();
    }
}
