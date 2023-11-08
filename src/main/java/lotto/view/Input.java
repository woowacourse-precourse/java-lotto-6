package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.SystemMessage;
import lotto.util.Validator;

public class Input {

    public static int getMoney(){
        while(true){
            System.out.printf(SystemMessage.INPUT_MONEY.getMessage());
            String moneyInput=getInput();
            System.out.printf(SystemMessage.EMPTY_STRING.getMessage());

            try {
                Validator.validateMoney(moneyInput);
                return convertToInt(moneyInput);
            }catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }
    public static List<Integer> getWinningNumber(){
        while(true){
            System.out.printf(SystemMessage.INPUT_WINNING_NUMBER.getMessage());
            List<String> winnigNumber = convertToList(getInput());
            System.out.printf(SystemMessage.EMPTY_STRING.getMessage());

            try {
                Validator.validateWinnigNumber(winnigNumber);
                return convertStrListToIntList(winnigNumber);
            }catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }
    public static int getBonusNumber(List<Integer> winningNumber){
        while (true){
            System.out.printf(SystemMessage.INPUT_BONUS_NUMBER.getMessage());
            String bonusNumberInput = getInput();
            System.out.printf(SystemMessage.EMPTY_STRING.getMessage());

            try {
                Validator.validateBonusNumber(bonusNumberInput, winningNumber);
                return convertToInt(bonusNumberInput);
            }catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }

    private static String getInput(){
        return Console.readLine();
    }

    private static int convertToInt(String str){
        try {
            int num = Integer.parseInt(str);
            return num;
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INT.getMessage());
        }
    }

    private static List<String> convertToList(String str){
        List<String> strList = new ArrayList<>(Arrays.asList(str.split(",")));
        ;
        return strList;
    }

    private static List<Integer> convertStrListToIntList(List<String> winnigNumberStr){
        List<Integer> winningNumberInt = new ArrayList<>();
        winnigNumberStr.forEach((str)->{
            winningNumberInt.add(convertToInt(str));
        });
        return winningNumberInt;
    }
}
