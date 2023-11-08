package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {
    private final static int LOTTO_UNIT_PRICE = 1000;
    private final static int LOTTO_MINIMUM_NUMBER = 1;
    private final static int LOTTO_MAXIMUM_NUMBER = 45;
    private List<Integer> lottoNumbers;

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
        boolean isValid = false;
        while (!isValid){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLottoNumbers = Console.readLine();
                lottoNumbers = validLottoNumber(inputLottoNumbers);
                isValid = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
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

    List<Integer> validLottoNumber(String input){
        validDelimeter(input);
        List<Integer> lottoNumbers = splitNumbers(input);
        validRange(lottoNumbers);

        return lottoNumbers;
    }

    void validDelimeter(String input){
        if(!(input.contains(","))){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,) 구분자를 사용하여 입력해야 합니다.");
        }
    }

    void validRange(List<Integer> lottoNumbers){
        for(int lottoNumber: lottoNumbers){
            if(lottoNumber < LOTTO_MINIMUM_NUMBER || lottoNumber > LOTTO_MAXIMUM_NUMBER){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    int inputBonusNumber(){
        int bonusNumber = 0;
        boolean isValid = false;
        while (!isValid){
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String number = Console.readLine();
                bonusNumber = validBonusNumber(number);
                isValid = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    int validBonusNumber(String input){
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 당첨 번호는 1개만 입력해야 합니다.");
        }
        if(bonusNumber < LOTTO_MINIMUM_NUMBER || bonusNumber > LOTTO_MAXIMUM_NUMBER){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(lottoNumbers.contains(input)) throw new IllegalArgumentException("[ERROR] 보너스 번호와 기존 당첨 번호는 중복될 수 없습니다.");
        return bonusNumber;
    }
}
