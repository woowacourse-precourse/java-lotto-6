package lotto.io;


import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ValueException;


public class BonusNumberReader {
    public static int bonusnumber(){
        String bonusnumber = Console.readLine();
        System.out.println("보너스 번호"+bonusnumber);
        ValueException.validateNumber(bonusnumber);
        return Integer.parseInt(bonusnumber);
    }
}
