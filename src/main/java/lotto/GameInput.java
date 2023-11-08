package lotto;

import Converter.Converter;
import camp.nextstep.edu.missionutils.Console;

public class GameInput {


    public static Integer insertMoney() throws IllegalArgumentException{
        String money = Console.readLine();
        return Converter.stringToMoney(money);
    }

    public static Lotto insertWinnigNumbers() throws IllegalArgumentException{
        String commaWinnigNumbers = Console.readLine();
        return Converter.commaStringToLotto(commaWinnigNumbers);
    }

    public static Integer insertBonusNumber() throws IllegalArgumentException{
        String number = Console.readLine();
        return Converter.stringToLottoNumber(number);
    }

}
