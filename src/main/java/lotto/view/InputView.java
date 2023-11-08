package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static Integer inputPurchaseAmount(){
        try{
            return validateInteger(preprocessValidateIntegerAmount(Console.readLine())));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }

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



}