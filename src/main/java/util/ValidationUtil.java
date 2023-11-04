package util;

public class ValidationUtil {
    public void validIntegerLottoAmount(String lottoAmount) {
        if (!lottoAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }
    public int validLottoAmount(String lottoAmount){
        int validAmount = Integer.parseInt(lottoAmount);
        if(validAmount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return validAmount;
    }
}
