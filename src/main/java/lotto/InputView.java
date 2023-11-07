package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {
    private final static int LOTTO_UNIT_PRICE = 1000;

    int inputLottoPrice(){
        int price = 0;
        boolean isValid = false;
        while (!isValid){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                price = validInput(input);
                isValid = true;
            } catch (IllegalArgumentException e){
                System.out.printf(e.getMessage());
            }
        }
        return price;
    }

    int validInput(String input){
        int price = validIntType(input);
        validUnit(price);
        validPositive(price);
        return price;
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

    List<Integer> inputLottoNumber(){
        List<Integer> lottoNumbers = null;
        boolean isValid = false;
        while (!isValid){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLottoNumbers = Console.readLine();
                lottoNumbers = validLottoNumber(inputLottoNumbers);
                isValid = true;
            } catch (IllegalArgumentException e){
                System.out.printf(e.getMessage());
            }
        }
        return lottoNumbers;
    }

    List<Integer> splitNumbers(String input){
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }
        return numbers;
    }

}
