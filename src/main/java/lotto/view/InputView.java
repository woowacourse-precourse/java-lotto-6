package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static Integer inputPurchaseAmount(){
        try{
            return validatePositiveAmount(validateInteger(preprocessValidateIntegerAmount(Console.readLine())));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }

    }

    public static List<Integer> inputWinningNumbers(){
        try {
            return separateWinningNumber(Console.readLine())
                    .stream()
                    .map(winningNumber -> validateInteger(winningNumber))
                    .collect(Collectors.toList());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }
    

    public static List<String> separateWinningNumber(String winningNumbers){
        return Stream
                .of(winningNumbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
    public static String preprocessValidateIntegerAmount(String playerPurchaseAmount){
        return playerPurchaseAmount.trim().replace(",","");
    }
    public static Integer validateInteger(String playerPurchaseAmount){
        try{
            return Integer.valueOf(playerPurchaseAmount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 값은 정수형태여야 합니다.");
        }
    }

    public static Integer validatePositiveAmount(Integer playerPurchaseAmount){
        if(playerPurchaseAmount<=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        return playerPurchaseAmount;
    }

}