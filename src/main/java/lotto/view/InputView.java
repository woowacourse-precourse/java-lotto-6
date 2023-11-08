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


}
