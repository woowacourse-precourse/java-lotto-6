package lotto.model;

import lotto.Constants;
public class LottoAmount {
    private final int amount;

    public LottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public void validateAmount(int amount){
        validateNatural(amount);
        validateDivisible(amount);
    }
    private static int validateNumber(String amount) throws IllegalArgumentException {
        try{
            return Integer.parseInt(amount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해주세요.");
        }
    }

    private void validateNatural(int amount){
        if (amount <= 0){
            throw new IllegalArgumentException("[ERROR] 양의 정수만 가능합니다.");
        }
    }

    private void validateDivisible(int amount){
        if (amount% Constants.LOTTO_MIN_AMOUNT != 0){
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
        }
    }

    public int calculateLottoCount() {
        return amount / Constants.LOTTO_MIN_AMOUNT;
    }
}
