package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.util.Lists.list;

public class InputSystem {

    public int inputPaymentAccount(){

        String paymentAccount = Console.readLine();
        checkIsDigit(paymentAccount);

        return Integer.parseInt(paymentAccount);
    }

    public int inputBonusNumber(){

        String bonusNumber = Console.readLine();
        checkIsDigit(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> inputWinningNumbers(){

        String winningNumbers = Console.readLine();
        List<String> stringNumberList = Arrays.asList(winningNumbers.split(","));
        //TODO: 리스트를 돌면서 숫자로 변환할수 있는 문자열인지 확인(예외검사)
        List<Integer> integerNumberList = stringNumberList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return integerNumberList;
    }

    private void checkIsDigit(final String inputNum){
        try{
            Integer.parseInt(inputNum);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
