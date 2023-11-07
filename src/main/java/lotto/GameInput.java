package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;

public class GameInput {

    private static final Integer INPUT_FAIL = null;

    public static Integer insertMoney(){
        String money = Console.readLine();
        try{
            InputValidator.checkMoney(money);
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
            return INPUT_FAIL;
        }
        return Integer.valueOf(money);
    }

    public static Lotto insertWinnigNumbers(){
        String commaWinnigNumbers = Console.readLine();
        try {
            IntegerValidator.checkWinnigNumbersValue(commaWinnigNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
        List<Integer> winningNumbers = Converter.convertCommaStringToListInt(commaWinnigNumbers);
        Collections.sort(winningNumbers);
        return new Lotto(Collections.unmodifiableList(winningNumbers));
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
