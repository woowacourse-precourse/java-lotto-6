package lotto.service;

import static lotto.settings.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.View;

public class Input {

    public static PurchaseAmount purChaseAmount(){
        while(true){
            View.requestPurchaseAmount();
            String input = readLine();
            try{
                validateTrim(input);
                validateNumber(input);

                return PurchaseAmount.from(stringToInt(input));
            }catch (IllegalArgumentException e){
                View.errorMessage(e.getMessage());
            }
        }
    }

    public static BonusNumber bonusNumber(Lotto winningLotto){
        while(true){
            View.requestBonusNumber();
            String input = readLine();
            try{
                validateTrim(input);
                validateNumber(input);

                return BonusNumber.from(winningLotto, stringToInt(input));
            }catch (IllegalArgumentException e){
                View.errorMessage(e.getMessage());
            }
        }
    }

    public static Lotto winningNumbers(){
        while(true){
            View.requestWinningNumber();
            try {
                String input = readLine();
                validateTrim(input);

                String[] inputs = input.split(",", -1);
                validateCommaBeforeAndAfter(inputs);
                validateNumber(inputs);

                return new Lotto(stringArrToIntegerList(inputs));
            } catch (IllegalArgumentException e) {
                View.errorMessage(e.getMessage());
            }
        }
    }

    private static void validateNumber(String input) {
        try{
            stringToInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateNumber(String[] inputs) {
        try{
            for (String input : inputs) {
                stringToInt(input);
            }
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateTrim(String input) {
        String trimInput = input.replaceAll(" ","");
        if(input.length() != trimInput.length()){
            throw new IllegalArgumentException(CONTAIN_SPACE.getMessage());
        }
    }
    private static void validateCommaBeforeAndAfter(String[] input) {
        for (String s : input) {
            if(s.isBlank()){
                throw new IllegalArgumentException(HAS_COMMA_ON_BOTH_SIDES.getMessage());
            }
        }
    }
    private static String readLine(){
        return Console.readLine();
    }

    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    private static List<Integer> stringArrToIntegerList(String[] inputs) {
        return Arrays.stream(inputs).map(Integer::parseInt).toList();
    }
}
