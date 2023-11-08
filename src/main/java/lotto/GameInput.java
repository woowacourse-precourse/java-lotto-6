package lotto;

import Converter.Converter;
import camp.nextstep.edu.missionutils.Console;

public class GameInput {


    public static Integer insertMoney(){
        String money = Console.readLine();
        try{
            return Converter.convertStringToMoney(money);
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
    }

    public static Lotto insertWinnigNumbers() throws IllegalArgumentException{
        String commaWinnigNumbers = Console.readLine();
        try {
            return Converter.convertCommaStringToLotto(commaWinnigNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
    }

    public static Integer insertBonusNumber(){
        String number = Console.readLine();
        try {
            return Converter.convertStringToLottoNumber(number);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
    }

}
