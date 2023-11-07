package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoRules;

public class PurchaseAmount {
    int pricePerLotto = LottoRules.PRICE_PER_LOTTO.getValue();
    int purchaseCount;

    public PurchaseAmount() {
    }

    public void generateLottoCount(){
        int inputPrice = tryToParseToInteger();
        this.purchaseCount = calculateLottoCount(inputPrice);
    }

    private String askPurchaseAmount() {
        return Console.readLine();
    }

    private int tryToParseToInteger() {
        while(true) {
            String purchaseAmount = askPurchaseAmount();
            try {
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구매 금액은 숫자형으로 입력해주세요");
            }
        }
    }

    private void PurchaseAmountValidate(int inputPrice) {
        tryToInputDividedPrice(inputPrice);
        tryToInputNoneZeroPrice(inputPrice);
    }

    private void tryToInputDividedPrice(int inputPrice) {
        try {
            IsInputPriceDividedPurchasePrice(inputPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000단위로 구매 금액을 입력해주세요 ");
            generateLottoCount();
        }
    }

    private void tryToInputNoneZeroPrice(int inputPrice) {
        try {
            IsNotZero(inputPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구매 금액은 0이 아닌 금액을 입력해주세요.");
            generateLottoCount();
        }
    }

    public boolean IsInputPriceDividedPurchasePrice(int inputPrice) throws IllegalArgumentException {
        if (inputPrice % pricePerLotto != 0) {
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

    public int calculateLottoCount(int inputPrice) {
        return (inputPrice / pricePerLotto);
    }
}
