package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSystem {

    public int inputPaymentAccount(){

        String paymentAccount = Console.readLine();

        checkIsDigit(paymentAccount);

        return Integer.parseInt(paymentAccount);
    }

    public List<Integer> inputWinningNumbers(){

        String winningNumbers = Console.readLine();
        List<String> stringNumberList = Arrays.asList(winningNumbers.split(","));

        for(String inputNum: stringNumberList){
            checkIsDigit(inputNum);
        }

        List<Integer> integerNumberList = stringNumberList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return integerNumberList;
    }

    public int inputBonusNumber(){

        String bonusNumber = Console.readLine();

        checkIsDigit(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public void checkIsDigit(final String inputNum){
        try{
            Integer.parseInt(inputNum);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해주세요.");
        }
    }
}
