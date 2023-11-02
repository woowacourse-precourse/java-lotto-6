package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    private static final int INPUT_FAIL = -1;

    public static int insertMoney(){
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

}
