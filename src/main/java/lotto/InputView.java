package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static int LOTTO_UNIT_PRICE = 1000;

    int inputLottoPrice(){
        int price = 0;
        boolean isValid = false;
        while (!isValid){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validInput(input);
                isValid = true;
            } catch (IllegalArgumentException e){
                System.out.printf(e.getMessage());
            }
        }
        return price;
    }

    void validInput(String input){
        int price = validIntType(input);
        validUnit(price);
        validPositive(price);
    }

    int validIntType(String input){
        int price;
        try{
            price = Integer.parseInt(input);
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매는 숫자를 입력해야합니다.");
        }
        return price;
    }

    void validUnit(int price){
        if((price%LOTTO_UNIT_PRICE) != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매는 1000원 단위 입니다.");
        }
    }

    void validPositive(int price){
        if(price <= 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 이상 입력해야 합니다.");
        }
    }

}
