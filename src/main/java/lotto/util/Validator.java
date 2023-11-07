package lotto.util;

public class Validator {
    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_PRICE_MIN = 0;

    public void check_InputMoney(String input) throws IllegalArgumentException{
        check_Empty(input);
        check_NotNumber(input);

        int money = Integer.parseInt(input);

        check_PositiveNumber(money);
        check_OverMinLottoPrice(money);
        check_NotDividedByPrice(money);
    }

    private void check_Empty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getMessage());
        }
    }

    private void check_NotNumber(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private void check_NotDividedByPrice(int money){
        if(money % LOTTO_PRICE != LOTTO_PRICE_MIN){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIVIDED_BY_PRICE.getMessage());
        }
    }

    private void check_PositiveNumber(int money){
        if(money < LOTTO_PRICE_MIN){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    private void check_OverMinLottoPrice(int money){
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_OVER_MIN_PRICE.getMessage());
        }
    }

}
