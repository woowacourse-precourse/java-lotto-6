package lotto.util;

public class Validator {
    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_PRICE_MIN = 0;

    private final static String ERROR = "[ERROR] ";

    public void check_InputMoney(String input) throws IllegalArgumentException{
        check_Empty(input);
        check_NotNumber(input);

        int money = Integer.parseInt(input);

        check_PositiveNumber(money);
        check_OverMinLottoPrice(money);
        check_NotDividedByPrice(money);
    }

    private void check_NotNumber(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ERROR + "투입 금액은 숫자여야 합니다.");
        }
    }

    private void check_Empty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(ERROR + "값을 입력해 주세요.");
        }
    }

    private void check_NotDividedByPrice(int money){
        if(money % LOTTO_PRICE != LOTTO_PRICE_MIN){
            throw new IllegalArgumentException(ERROR + LOTTO_PRICE +"원 단위로 금액을 투입해 주세요!");
        }
    }

    private void check_PositiveNumber(int money){
        if(money < LOTTO_PRICE_MIN){
            throw new IllegalArgumentException(ERROR + "투입 금액은 음수가 될 수 없습니다.");
        }
    }

    private void check_OverMinLottoPrice(int money){
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(ERROR + "로또를 구매할 돈이 부족합니다.");
        }
    }

}
