package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoConstants;

public class PurchaseAmount {
    int PURCHASEPRICE = LottoConstants.PURCHASE_PRICE.getValue();
    int PurchaseCount;

    public PurchaseAmount() {
    }

    public void calculateLootoCount(){
        int inputPrice = parseInputAmount();
        PurchaseAmountValidate(inputPrice);
        PurchaseCount = calculatePurchaseLottoCount(inputPrice);
    }

    private int parseInputAmount() {
        String purchaseAmount = Console.readLine();
        return tryToParseInputAmount(purchaseAmount);
    }

    private int tryToParseInputAmount(String purchseAmount) {
        while (!isNumeric(purchseAmount)) {
            System.out.println("[Error] 구매 금액은 숫자형으로 입력해주세요");
            purchseAmount = Console.readLine();
        }
        return Integer.parseInt(purchseAmount);
    }

    private boolean isNumeric(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void PurchaseAmountValidate(int inputPrice) {
        tryToInputDividedPrice(inputPrice);
        tryToInputNoneZeroPrice(inputPrice);
    }

    private void tryToInputDividedPrice(int inputPrice) {
        try {
            IsInputPriceDividedPurchasePrice(inputPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 1000단위로 구매 금액을 입력해주세요 ");
            calculateLootoCount();
        }
    }

    private void tryToInputNoneZeroPrice(int inputPrice) {
        try {
            IsNotZero(inputPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 구매 금액은 0이 아닌 금액을 입력해주세요.");
            calculateLootoCount();
        }
    }

    public boolean IsInputPriceDividedPurchasePrice(int inputPrice) throws IllegalArgumentException {
        if (inputPrice % PURCHASEPRICE != 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public boolean IsNotZero(int inputPrice) throws IllegalArgumentException {
        if (inputPrice == 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int calculatePurchaseLottoCount(int inputPrice) {
        return (inputPrice % PURCHASEPRICE);
    }
}
