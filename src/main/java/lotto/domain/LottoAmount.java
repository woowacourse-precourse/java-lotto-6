package lotto.domain;

public class LottoAmount {
    private static final int LOTTO_PRICE=1000;
    private static final String NOT_NUMBER_ERROR ="[ERROR] 숫자가 아닌 값을 입력하셨습니다.";
    private static final String INPUT_FORMAT_ERROR ="[ERROR] 입력값이" +LOTTO_PRICE+"로 나누어 떨어지지 않습니다.";
    private static final String RANGE_ERROR ="[ERROR] 금액은 양수값이어야 합니다.";

    private final int amount;

    public LottoAmount(int amount){
        checkAmount(amount);
        this.amount =amount;
    }

    public int calcLottoNum(){
        return amount /LOTTO_PRICE;
    }

    private void checkAmount(int amount){
        checkNumber(amount);
        checkPositive(amount);
        checkFormat(amount);

    }
    private static int checkNumber(int amount) {
        try{
            return amount;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }


    private static void checkPositive(int amount)
    {
        if(amount<=0){
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void checkFormat(int amount){
        if(amount%LOTTO_PRICE !=0){
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);

        }
    }

}
