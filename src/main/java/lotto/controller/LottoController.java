package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.Purchase;
import lotto.view.LottoView;

import static lotto.model.LottoStatistics.DEFAULT_VALUE;
import static lotto.util.ErrorMessage.*;

public class LottoController { //입력을 받아서 model에 전달, 간단한 입력형식(공백인지, 숫자인지)검증, view에 정보 요청 및 결과 표시, 예외 상황 처리 및 다시 입력 요청

    private final LottoMachine lottoMachine;
    private final LottoStatistics lottoStatistics;
    private final Purchase purchase;

    public LottoController(LottoMachine lottoMachine, LottoStatistics lottoStatistics, Purchase purchase) {
        this.lottoMachine = lottoMachine;
        this.lottoStatistics = lottoStatistics;
        this.purchase = purchase;
    }

    public void run() {
        int purchaseAmount = readAndValidatePurchaseAmount();

    }

    private int readAndValidatePurchaseAmount() {
        int purchaseAmount = DEFAULT_VALUE;
        boolean validPurchase = false;
        while (!validPurchase) {
            try {
                String purchaseAmountInput = LottoView.readPurchaseAmount();
                validateNumber(purchaseAmountInput);
                purchaseAmount = Integer.parseInt(purchaseAmountInput);
                validPurchase = true;
            } catch (IllegalArgumentException e) {
                LottoView.displayErrorMessage(e);
            }
        }
        return purchaseAmount;
    }

    public void validateNumber(String input) {
        checkInputEmpty(input);
        checkForWhitespace(input);
        checkNumeric(input);
    }

    private void checkInputEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private void checkForWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private void checkNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_ONLY_NUMBER);
        }
    }
}
