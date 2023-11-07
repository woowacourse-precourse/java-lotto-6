package lotto.domain;

public class PlayerLottoAmount {

    public PlayerLottoAmount(String amount){
        validateNumber(amount);
    }

    private void validateNumber(String amount) {
        int amountCheck = Integer.parseInt(amount);
        if(amountCheck%1000 !=0) throw new IllegalArgumentException();
    }
}
