package util;

public class ValidationUtil {
    public int validPurchaseLottoAmount(String lottoPurchaseAmount){
        validPurchaseIntegerLottoAmount(lottoPurchaseAmount);
        return validPurchaseRemainLottoAmount(lottoPurchaseAmount);
    }
    public void validPurchaseIntegerLottoAmount(String lottoPurchaseAmount) {
        if (!lottoPurchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }
    public int validPurchaseRemainLottoAmount(String lottoPurchaseAmount){
        int validPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
        if(validPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return validPurchaseAmount;
    }

    public String[] validWinningNumber(String input){
        String[] validEachWinningNumber = input.split(",");
        validCountWinningNumber(validEachWinningNumber);
    }

    public void validCountWinningNumber(String[] array){
        if(array == null || array.length != 6){
            throw new IllegalArgumentException();
        }
    }
}
