package lotto;

import static lotto.GuideMessage.COMMA;
import static lotto.LottoSettingValue.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameInput {

    private static final int INPUT_FAIL = -1;

    public static int insertMoney(){ // int -> Integer , INPUT FAIL == null
        String money = Console.readLine();
        try{
            IntegerValidator.isZeroOrPositiveInteger(money);
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
        return new Lotto(convertCommaStringToListInt(commaWinnigNumbers));
    }

    public static List<Integer> convertCommaStringToListInt(String commaString){
        List<Integer> winnigNumbers = new ArrayList<>(LOTTO_SIZE);
        for(String number : commaString.split(COMMA)){
            winnigNumbers.add(Integer.valueOf(number));
        }
        return winnigNumbers;
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
