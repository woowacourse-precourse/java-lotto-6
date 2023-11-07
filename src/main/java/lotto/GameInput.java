package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    private static final Integer INPUT_FAIL = null;

    public static Integer insertMoney(){
        String money = Console.readLine();
        try{
            return Converter.convertStringToMoney(money);
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
            return INPUT_FAIL;
        }
    }

    public static Lotto insertWinnigNumbers() throws IllegalArgumentException{
        String commaWinnigNumbers = Console.readLine();
        try {
            Lotto winningNumbers = Converter.convertCommaStringToLotto(commaWinnigNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
    }

    public static Integer insertBonusNumber(){
        String number = Console.readLine();
        try {
            IntegerValidator.checkBonusNumberValue(number);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
        return Integer.valueOf(number);
    }

}
